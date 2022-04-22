package com.dana.onboardingproject.examplemain

import com.dana.domain.listrecipe.model.Recipe

interface MainActivityContract {

    interface Presenter {
        fun getListRecipes(from: Int, size: Int)
    }

    interface View {
        fun setListRecipes(recipes: List<Recipe>)
    }
}