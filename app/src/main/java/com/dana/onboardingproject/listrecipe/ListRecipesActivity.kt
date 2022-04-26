/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.base.BaseActivity
import com.dana.onboardingproject.databinding.ActivityListRecipesBinding
import com.dana.onboardingproject.di.component.DaggerListRecipeComponent
import com.dana.onboardingproject.di.module.ListRecipeModule
import com.dana.onboardingproject.listrecipe.adapter.RecipeAdapter
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipesActivity, v 0.1 22/04/22 15.27 by Iga Noviyanti
 */
class ListRecipesActivity : BaseActivity<ActivityListRecipesBinding>() {

    @Inject
    lateinit var presenter: ListRecipeContract.Presenter

    private var firstIdRecipe = 0

    private val recipeAdapter = RecipeAdapter{
        Toast.makeText(this@ListRecipesActivity, "Recipe ${it.name}", Toast.LENGTH_SHORT).show()
    }

    override fun setViewBinding() = ActivityListRecipesBinding.inflate(layoutInflater)

    override fun setupData(savedInstanceState: Bundle?) {
        initInjector()
        presenter.getListRecipes(firstIdRecipe)
    }

    override fun initializeView(binding: ActivityListRecipesBinding) {
        with(binding) {
            rvRecipe.apply {
                adapter = recipeAdapter
                val layoutManagerGrid = GridLayoutManager(this@ListRecipesActivity, 1)
                layoutManager = layoutManagerGrid
                itemAnimator = DefaultItemAnimator()
            }

            nsvListRecipe.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                    firstIdRecipe += 10
                    presenter.getListRecipes(firstIdRecipe)
                    recipeAdapter.showLoadingMoreData(true)
                }

                if (scrollY > oldScrollY) {
                    fabToUp.hide()
                } else {
                    fabToUp.show()
                }
            })

            fabToUp.setOnClickListener {
                nsvListRecipe.smoothScrollTo(0,0)
            }
        }
    }

    private fun initInjector() {
        DaggerListRecipeComponent.builder()
            .applicationComponent(getApplicationComponent())
            .listRecipeModule(resultListRecipe())
            .build()
            .inject(this)
    }

    private fun resultListRecipe() = ListRecipeModule(object : ListRecipeContract.View {
        override fun setListRecipes(recipes: List<Recipe>) {
            recipeAdapter.showLoadingMoreData(false)
            recipeAdapter.insertItems(recipes)
        }

        override fun setLoading(isLoading: Boolean) {
            if(recipeAdapter.itemCount == 0) {
                binding.shimmerLoading.rootShimmerLoading.isVisible = isLoading
            }
        }

        override fun setErrorHandler(throwable: Throwable) {
            Log.e("error", "is error ${throwable.message}")
        }
    })

}