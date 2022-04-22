package com.dana.onboardingproject.examplemain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.OnboardingApp
import com.dana.onboardingproject.R
import com.dana.onboardingproject.di.MainActivityModule
import com.dana.onboardingproject.di.component.DaggerMainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    @Inject
    lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInjector()

        presenter.getListRecipes(0, 5)
    }

    fun getApplicationComponent() = (application as OnboardingApp).getApplicationComponent()

    override fun setListRecipes(recipes: List<Recipe>) {
        Log.e("recipes", "recipes size ${recipes.size}")
    }

    private fun initInjector() {
        DaggerMainActivityComponent.builder()
            .applicationComponent(getApplicationComponent())
            .mainActivityModule(MainActivityModule(this))
            .build()
            .inject(this)
    }
}