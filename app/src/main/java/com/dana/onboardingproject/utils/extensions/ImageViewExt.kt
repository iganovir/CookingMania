/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.utils.extensions

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dana.onboardingproject.R
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import java.lang.Math.round


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ImageViewExt, v 0.1 25/04/22 07.11 by Iga Noviyanti
 */

/**
 * This Function will Load any source to an ImageView with Desired format And Request
 * @param source is the imageSource with Type of Bitmap, Drawable, String, Uri , resDrawable, File, ByteArray And CustomModel
 * @param corner give an option of image transform type (Rounded, Circle, Rectangle)
 * @param overrideSize will resize image with desired pixel size
 * @param radius will round corner to desired size of [Int] pixels
 * @param shimmerLoad Condition to give shimmer placeholder load effect if condition set to true
 * @param background give background outside image source
 * @param scaleType is Scaling Type that will be displayed to user
 * @param placeHolder give a default image to ImageView when target image is loading or error
 */


fun ImageView.loadImage(
    source: Any?,
    corner: ImageCornerOptions? = ImageCornerOptions.NORMAL,
    radius: Int? = null,
    shimmerLoad: Boolean = false,
    shimmerDuration: Long = 1000,
    overrideSize: Int? = null,
    placeHolder: Int? = R.color.grey,
    @ColorRes background: Int? = null,
    scaleType: ImageView.ScaleType? = null
) {
    val requestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    when (corner) {
        ImageCornerOptions.NORMAL -> {
            requestOptions.transform(
                CenterCrop()
            )
        }

        ImageCornerOptions.CIRCLE -> {
            requestOptions.transform(
                CenterCrop(),
                RoundedCorners(
                    resources.getDimensionPixelSize(
                        R.dimen.image_options_circle_radius
                    )
                )
            )
        }

        ImageCornerOptions.ROUNDED -> {
            val cornerRadius = if (radius != null) {
                round(
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        radius.toFloat(),
                        resources.displayMetrics
                    )
                ).toInt()
            } else {
                resources.getDimensionPixelSize(R.dimen.image_options_round_radius)
            }

            requestOptions.transform(
                CenterCrop(),
                RoundedCorners(cornerRadius)
            )
        }
    }

    source?.let {
        if (scaleType == ImageView.ScaleType.FIT_CENTER) requestOptions.fitCenter()
        else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) requestOptions.centerInside()

        if (overrideSize != null) {
            requestOptions.override(overrideSize)
        }

        if (shimmerLoad) {
            val shimmer = Shimmer.AlphaHighlightBuilder()
                .setDuration(shimmerDuration)
                .setBaseAlpha(0.7f)
                .setHighlightAlpha(0.6f)
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .setAutoStart(true)
                .build()

            val shimmerDrawable = ShimmerDrawable().apply {
                setShimmer(shimmer)
            }

            if (placeHolder != null) {
                requestOptions.placeholder(shimmerDrawable).error(placeHolder)
            }
        } else {
            if (placeHolder != null) {
                requestOptions.placeholder(placeHolder).error(placeHolder)
            }
        }

        Glide.with(context)
            .load(it)
            .apply(requestOptions)
            .into(this)

        if (background != null) {
            doOnPreDraw {
                setBackground(
                    context.createCircleDrawable(
                        Pair(measuredWidth, measuredHeight),
                        background
                    )
                )
            }
        }
    }
}

// Image Shape Options
enum class ImageCornerOptions {
    NORMAL, CIRCLE, ROUNDED
}

fun Context.createCircleDrawable(
    whSize: Pair<Int,Int>,
    @ColorRes backgroundColor: Int = R.color.black
): GradientDrawable {
    return GradientDrawable().apply {
        shape = GradientDrawable.OVAL
        cornerRadii = floatArrayOf(0f,0f,0f,0f,0f,0f,0f,0f)
        color = colorStateList(backgroundColor)
        setSize(whSize.first, whSize.second)
    }
}

fun Context?.colorStateList(@ColorRes colorRes: Int): ColorStateList {
    return this?.let { ContextCompat.getColorStateList(it, colorRes) }
        ?: ColorStateList.valueOf(Color.TRANSPARENT)
}



