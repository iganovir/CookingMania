/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.R
import com.dana.onboardingproject.databinding.ItemRecipeBinding
import com.dana.onboardingproject.utils.extensions.loadImage

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeItemList, v 0.1 24/04/22 12.53 by Iga Noviyanti
 */
class ItemRecipeViewHolder(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Recipe, callback: (recipe: Recipe) -> Unit) {
        with(binding) {
            tvRecipeName.text = item.name
            ivRecipeThumbnail.loadImage(
                source = item.thumbnail,
                shimmerLoad = true,
                radius = R.dimen.standard_margin
            )

            root.setOnClickListener {
                callback(item)
            }
        }

    }
}