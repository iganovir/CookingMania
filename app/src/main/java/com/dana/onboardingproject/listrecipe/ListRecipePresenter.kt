/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe

import com.dana.domain.listrecipe.interactor.GetListRecipe
import com.dana.domain.listrecipe.interactor.GetListRecipePaging
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipePresenter, v 0.1 24/04/22 23.38 by Iga Noviyanti
 */
class ListRecipePresenter @Inject constructor(
    private val view: ListRecipeContract.View,
    private val getRecipe: GetListRecipe
) : ListRecipeContract.Presenter {

    override fun getListRecipes(from: Int, size: Int?) {
        view.setLoading(true)
        getRecipe.execute(
            GetListRecipe.Params(from = from, size = size ?: 0),
            onSuccess = { recipes ->
                view.setLoading(false)
                view.setListRecipes(recipes)
            },
            onError = { throwable ->
                view.setErrorHandler(throwable)
            },
        )
    }
}