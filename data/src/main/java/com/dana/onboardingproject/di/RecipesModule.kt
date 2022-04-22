package com.dana.onboardingproject.di

import com.dana.domain.repository.RecipeRepository
import com.dana.domain.usecase.GetRecipesListUseCase
import com.dana.onboardingproject.datasource.RecipesDataSource
import com.dana.onboardingproject.repository.RecipeSourceRepository
import com.dana.onboardingproject.source.remote.RecipeApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RecipesModule {

    @Provides
    @Singleton
    fun provideRecipesDataSourceNetwork(service: RecipeApi) =
        RecipesDataSource.Network(service)

    @Provides
    @Singleton
    fun provideRecipesDataSourceFactory(
        network: RecipesDataSource.Network
    ) = RecipesDataSource.Factory(lazy { network })

//    @Provides
//    @Singleton
//    fun provideRecipesDataSourceCache() = RecipesDataSource.Cache()

    @Provides
    @Singleton
    fun provideRecipeSourceRepository(
        factory: RecipesDataSource.Factory
    ) = RecipeSourceRepository(factory)

    @Provides
    @Singleton
    fun provideGetListRecipeUseCase(
        repository: RecipeSourceRepository
    ) = GetRecipesListUseCase(repository)

    @Provides
    @Singleton
    fun provideRecipeRepository(
        repositorySourceRepository: RecipeSourceRepository
    ) : RecipeRepository = repositorySourceRepository
}