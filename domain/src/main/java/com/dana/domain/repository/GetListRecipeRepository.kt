package com.dana.domain.repository

import io.reactivex.Observable

interface RecipeRepository {
    fun getListRecipe(from: Int, size: Int) : Observable<Int>
}

//interface GetListRecipeCacheRepository