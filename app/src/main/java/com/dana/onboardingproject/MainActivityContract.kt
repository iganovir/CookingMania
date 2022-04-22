package com.dana.onboardingproject

interface MainActivityContract {

    interface Presenter {
        fun getListRecipes(from: Int, size: Int)
    }

    interface View {
        fun setListRecipes(recipesSize: Int)
    }
}