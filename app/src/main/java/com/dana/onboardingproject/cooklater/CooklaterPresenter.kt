/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.cooklater

import com.dana.domain.listrecipe.interactor.GetListRecipeLocal
import com.dana.domain.listrecipe.model.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version CooklaterPresenter, v 0.1 27/04/22 21.16 by Iga Noviyanti
 */
class CooklaterPresenter @Inject constructor(
    private val view: CooklaterContract.View,
    private val getRecipe: GetListRecipeLocal,
    private val uiContext: CoroutineContext = Dispatchers.Main
) : CooklaterContract.Presenter, CoroutineScope {

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = uiContext + job

    override fun getListRecipes() {
        launch {
            val recipes = getRecipe.getListRecipe()
            view.setListRecipes(recipes)
        }
    }

    override fun onDestroy() {
        job.cancel()
    }
}