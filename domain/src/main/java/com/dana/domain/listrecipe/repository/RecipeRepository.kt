package com.dana.domain.listrecipe.repository

import androidx.paging.PagingData
import com.dana.domain.listrecipe.model.Recipe
import io.reactivex.Flowable
import io.reactivex.Observable

interface RecipeRepository {
    fun getListRecipe(from: Int, size: Int) : Observable<List<Recipe>>
    fun getListRecipeLocal() : List<Recipe>
    fun getListRecipePagination(from: Int, size: Int) : Flowable<PagingData<Recipe>>
    fun getDetailRecipe(id: Int) : Observable<Recipe>
    fun getDetailRecipeLocal(id: Int) : Recipe?
    fun addRecipeToCookLater(recipe: Recipe) : Long
    fun deleteRecipeFromCooklater(recipe: Recipe)
}