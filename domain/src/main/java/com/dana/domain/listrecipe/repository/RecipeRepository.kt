package com.dana.domain.listrecipe.repository

import com.dana.domain.listrecipe.model.Recipe
import io.reactivex.Observable

interface RecipeRepository {
    fun getListRecipe(from: Int, size: Int) : Observable<List<Recipe>>
}