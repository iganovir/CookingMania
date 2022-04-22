package com.dana.onboardingproject.repository

import com.dana.domain.listrecipe.repository.RecipeRepository
import com.dana.onboardingproject.datasource.RecipesDataSource
import io.reactivex.Observable

class RecipeSourceRepository(private val factory: RecipesDataSource.Factory):
    RecipeRepository {
    override fun getListRecipe(from: Int, size: Int): Observable<Int> = factory.network.getListRecipe(from = from, size = size)
}