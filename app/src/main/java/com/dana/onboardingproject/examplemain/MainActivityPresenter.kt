package com.dana.onboardingproject.examplemain

import com.dana.domain.listrecipe.interactor.GetListRecipe
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val view: MainActivityContract.View,
    private val getRecipe: GetListRecipe
) : MainActivityContract.Presenter {

    override fun getListRecipes(from: Int, size: Int) {
        getRecipe.execute(
            GetListRecipe.Params(from = from, size = size),
            onSuccess = { recipes ->
                view.setListRecipes(recipes)
            },
            onError = {

            }
        )
    }
}