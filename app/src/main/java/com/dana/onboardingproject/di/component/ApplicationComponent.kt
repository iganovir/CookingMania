package com.dana.onboardingproject.di.component

import android.content.Context
import com.dana.domain.listrecipe.repository.RecipeRepository
import com.dana.onboardingproject.di.NetworkModule
import com.dana.onboardingproject.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ApplicationComponent, v 0.1 21/04/22 10.10 by Iga Noviyanti
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent {
    fun context(): Context
    fun recipeRepository(): RecipeRepository
}