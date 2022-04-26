package com.dana.domain.listrecipe.repository

import androidx.paging.PagingData
import com.dana.domain.listrecipe.model.Recipe
import io.reactivex.Flowable
import io.reactivex.Observable

interface RecipeRepository {
    fun getListRecipe(from: Int, size: Int) : Observable<List<Recipe>>
    fun getListRecipePagination(from: Int, size: Int) : Flowable<PagingData<Recipe>>
}