package com.dana.onboardingproject.repository

import com.dana.domain.repository.RecipeRepository
import com.dana.onboardingproject.datasource.RecipesDataSource
import io.reactivex.Observable

class RecipeSourceRepository(private val factory: RecipesDataSource.Factory):
    RecipeRepository {
//    override suspend fun getExample(exampleId: String): BaseData = factory.network.getExample(exampleId)

    override fun getListRecipe(from: Int, size: Int): Observable<Int> = factory.network.getListRecipe(from = from, size = size)
}