package com.dana.onboardingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


    override fun setListRecipes(recipesSize: Int) {
        Log.e("recipes", "recipes size $recipesSize")
    }

    private fun initInjector() {
        DaggerMainActivityComponent.builder()
            .applicationComponent(getApplicationComponent())
            .mainActivityModule(MainActivityModule(this))
            .build()
            .inject(this)
    }
}