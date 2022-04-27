/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.detailrecipe

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.R
import com.dana.onboardingproject.base.BaseActivity
import com.dana.onboardingproject.databinding.ActivityDetailRecipeBinding
import com.dana.onboardingproject.detailrecipe.adapter.CookingInstructionAdapter
import com.dana.onboardingproject.di.component.DaggerDetailRecipeComponent
import com.dana.onboardingproject.di.module.DetailRecipeModule
import com.dana.onboardingproject.utils.extensions.loadImage
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version DetailRecipeActivity, v 0.1 26/04/22 14.28 by Iga Noviyanti
 */
class DetailRecipeActivity : BaseActivity<ActivityDetailRecipeBinding>(),
    DetailRecipeContract.View {

    companion object {
        const val RECIPE_ID = "RECIPE_ID"
    }

    @Inject
    lateinit var presenter: DetailRecipeContract.Presenter

    private val recipeId by lazy {
        intent.getIntExtra(RECIPE_ID, 0)
    }

    private lateinit var recipeData: Recipe
    private var isAddedToCooklater = false

    private val instructionAdapter = CookingInstructionAdapter()

    override fun setViewBinding() = ActivityDetailRecipeBinding.inflate(layoutInflater)

    override fun setupData(savedInstanceState: Bundle?) {
        initInjector()
        presenter.getDetailRecipe(recipeId)
    }

    override fun initializeView(binding: ActivityDetailRecipeBinding) {
        with(binding) {
            setSupportActionBar(toolbar)
            rvInstruction.apply {
                adapter = instructionAdapter
                layoutManager = LinearLayoutManager(this@DetailRecipeActivity)
                itemAnimator = DefaultItemAnimator()
            }
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = ""
            }
            toolbar.apply {
                setNavigationOnClickListener {
                    finish()
                }
                setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24)
            }
            btnAddToCookLater.setOnClickListener {
                if(isAddedToCooklater)
                    presenter.deleteFromCookLater(recipeData)
                else
                    presenter.addToCookLater(recipeData)
            }

        }
    }

    private fun initInjector() {
        DaggerDetailRecipeComponent.builder()
            .applicationComponent(getApplicationComponent())
            .detailRecipeModule(DetailRecipeModule(this))
            .build()
            .inject(this)
    }

    override fun setDetailRecipe(recipe: Recipe) {
        recipeData = recipe
        with(binding) {
            tvRecipeName.text = recipe.name
            ivRecipeThumbnail.loadImage(
                source = recipe.thumbnail,
                shimmerLoad = true,
                radius = R.dimen.standard_margin_1x
            )
            if (!recipe.description.isNullOrEmpty()) tvRecipeDesc.text =
                recipe.description else tvRecipeDesc.isVisible = false
            tvRecipeServings.text = recipe.numServing.toString()
            if (!recipe.cookTimeMinutes.isNullOrEmpty()) tvRecipeTime.text = getString(
                R.string.cooking_time,
                recipe.cookTimeMinutes
            ) else tvRecipeTime.isVisible = false
            instructionAdapter.insertItems(recipe.instructions.orEmpty())
        }
    }

    override fun setLoading(isLoading: Boolean) {
        binding.lavLoading.isVisible = isLoading
        binding.clDetailContent.isVisible = isLoading.not()
    }

    override fun setErrorHandler(throwable: Throwable) {
        handleError(this@DetailRecipeActivity, throwable)
    }

    override fun setDataIsAddedToCookLater(isAdded: Boolean) {
        isAddedToCooklater = isAdded
        with(binding) {
            btnAddToCookLater.apply {
                if(isAdded) {
                    setBackgroundColor(
                        ContextCompat.getColor(
                            this@DetailRecipeActivity,
                            R.color.red
                        )
                    )
                    text = getString(R.string.recipe_added_to_cook_later)
                    setTextColor(ContextCompat.getColor(this@DetailRecipeActivity, R.color.white))
                } else {
                    setBackgroundColor(
                        ContextCompat.getColor(
                            this@DetailRecipeActivity,
                            R.color.white
                        )
                    )
                    text = getString(R.string.recipe_add_to_cook_later)
                    setTextColor(ContextCompat.getColor(this@DetailRecipeActivity, R.color.red))
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}