/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe

import android.os.Bundle
import android.widget.Toast
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

    private val recipeAdapter = RecipeAdapter {
        Toast.makeText(this@ListRecipesActivity, "Recipe ${it.name} clicked", Toast.LENGTH_SHORT)
            .show()
    }

    override fun setViewBinding() = ActivityListRecipesBinding.inflate(layoutInflater)

    override fun setupData(savedInstanceState: Bundle?) {
        initInjector()
        presenter.getListRecipes(firstIdRecipe)
    }

    override fun initializeView(binding: ActivityListRecipesBinding) {
        binding.rvRecipe.apply {
            adapter = recipeAdapter
            val layoutManagerGrid = GridLayoutManager(this@ListRecipesActivity, 2)
            layoutManager = layoutManagerGrid
            itemAnimator = DefaultItemAnimator()
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
            recipeAdapter.insertItems(recipes)
        }

        override fun setLoading(isLoading: Boolean) {
            TODO("Not yet implemented")
        }

        override fun setErrorHandler(throwable: Throwable) {
            TODO("Not yet implemented")
        }
    })

}