/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.cooklater

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.R
import com.dana.onboardingproject.base.BaseActivity
import com.dana.onboardingproject.databinding.ActivityListRecipesBinding
import com.dana.onboardingproject.detailrecipe.DetailRecipeActivity
import com.dana.onboardingproject.di.component.DaggerCooklaterComponent
import com.dana.onboardingproject.di.module.CooklaterModule
import com.dana.onboardingproject.listrecipe.adapter.RecipeAdapter
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version CooklaterActivity, v 0.1 27/04/22 21.15 by Iga Noviyanti
 */
class CooklaterActivity : BaseActivity<ActivityListRecipesBinding>(), CooklaterContract.View  {

    @Inject
    lateinit var presenter: CooklaterContract.Presenter

    private val recipeAdapter = RecipeAdapter{
        val intent = Intent(this@CooklaterActivity, DetailRecipeActivity::class.java)
        intent.putExtra(DetailRecipeActivity.RECIPE_ID, it.id)
        startActivity(intent)
    }

    override fun setViewBinding() = ActivityListRecipesBinding.inflate(layoutInflater)

    override fun setupData(savedInstanceState: Bundle?) {
        initInjector()
        presenter.getListRecipes()
    }

    override fun initializeView(binding: ActivityListRecipesBinding) {
        with(binding) {
            tvLabelRandomRecipeTitle.text = getString(R.string.cook_later_title)
            tvLabelRandomRecipeDesc.text = getString(R.string.cook_later_desc)

            rvRecipe.apply {
                adapter = recipeAdapter
                layoutManager = LinearLayoutManager(this@CooklaterActivity)
                itemAnimator = DefaultItemAnimator()
            }

            nsvListRecipe.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, oldScrollY ->
                if (scrollY > oldScrollY) {
                    fabToUp.hide()
                } else {
                    fabToUp.show()
                }
            })

            fabToUp.setOnClickListener {
                nsvListRecipe.smoothScrollTo(0,0)
            }

            ivCookLater.isVisible = false
            shimmerLoading.rootShimmerLoading.isVisible = false
        }
    }

    private fun initInjector() {
        DaggerCooklaterComponent.builder()
            .applicationComponent(getApplicationComponent())
            .cooklaterModule(CooklaterModule(this))
            .build()
            .inject(this)
    }

    override fun setListRecipes(recipes: List<Recipe>) {
        recipeAdapter.showLoadingMoreData(false)
        MainScope().launch {
            recipeAdapter.removeAllItems()
            recipeAdapter.insertItems(recipes)
        }
    }

    override fun setLoading(isLoading: Boolean) {

    }

    override fun setErrorHandler(throwable: Throwable) {
        handleError(this@CooklaterActivity, throwable)
    }

    override fun onResume() {
        super.onResume()
        presenter.getListRecipes()
    }
}