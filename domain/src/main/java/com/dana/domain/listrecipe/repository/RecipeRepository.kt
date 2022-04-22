package com.dana.domain.listrecipe.repository

import io.reactivex.Observable

interface RecipeRepository {
    fun getListRecipe(from: Int, size: Int) : Observable<Int>
}