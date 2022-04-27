/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.detailrecipe

import com.dana.domain.listrecipe.interactor.*
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.ListRecipeContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version DetailRecipePresenter, v 0.1 26/04/22 15.41 by Iga Noviyanti
 */
class DetailRecipePresenter @Inject constructor(
    private val view: DetailRecipeContract.View,
    private val getRecipe: GetDetailRecipe,
    private val getRecipeLocal: GetDetailRecipeLocal,
    private val addToCookLater: AddToCookLater,
    private val deleteRecipeLocal: DeleteRecipeLocal,
    private val uiContext: CoroutineContext = Dispatchers.Main
) : DetailRecipeContract.Presenter, CoroutineScope {
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = uiContext + job

    override fun getDetailRecipe(id: Int) {
        view.setLoading(true)
        launch {
            val local = getRecipeLocal.getDetailRecipe(id)
            if (!local?.name.isNullOrEmpty()) view.setDataIsAddedToCookLater(true)
        }

        getRecipe.execute(
            GetDetailRecipe.Params(id = id),
            onSuccess = { recipe ->
                view.setLoading(false)
                view.setDetailRecipe(recipe)
            },
            onError = { throwable ->
                view.setErrorHandler(throwable)
            },
        )
    }

    override fun addToCookLater(recipe: Recipe) {
        launch {
            addToCookLater.addRecipeToCooklater(recipe)
        }
        view.setDataIsAddedToCookLater(true)
    }

    override fun onDestroy() {
        job.cancel()
    }

    override fun deleteFromCookLater(recipe: Recipe) {
        launch {
            deleteRecipeLocal.deleteRecipeFromCooklater(recipe)
        }
        view.setDataIsAddedToCookLater(false)
    }
}