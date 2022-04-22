package com.dana.onboardingproject

import com.dana.domain.usecase.GetRecipesListUseCase
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val view: MainActivityContract.View,
    private val getRecipes: GetRecipesListUseCase
) : MainActivityContract.Presenter{

    override fun getListRecipes(from: Int, size: Int) {
        getRecipes.execute(
            GetRecipesListUseCase.Params(from = from, size = size),
            onSuccess = { recipes ->
                view.setListRecipes(recipes)
            },
            onError = {

            }
        )
    }
}