package com.dana.onboardingproject.di.module

import android.app.Application
import android.content.Context
import com.dana.domain.listrecipe.repository.RecipeRepository
import com.dana.onboardingproject.listrecipe.repository.RecipeEntityRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ApplicationModule, v 0.1 21/04/22 10.11 by Iga Noviyanti
 */
@Module
class ApplicationModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = app

    @Singleton
    @Provides
    fun provideApplication(): Application = app

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeEntityRepository: RecipeEntityRepository
    ): RecipeRepository =
        recipeEntityRepository

}