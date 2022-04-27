package com.dana.onboardingproject

import android.app.Application
import com.dana.onboardingproject.di.NetworkModule
import com.dana.onboardingproject.di.component.ApplicationComponent
import com.dana.onboardingproject.di.component.DaggerApplicationComponent
import com.dana.onboardingproject.di.module.ApplicationModule

class CookingApp() : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    fun getApplicationComponent() = applicationComponent

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule)
            .build()
    }

}