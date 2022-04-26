/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.dana.onboardingproject.listrecipe.mapper.toEntity
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.network.result.ListRecipesResult
import com.dana.onboardingproject.network.RecipeAPI
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version paging, v 0.1 25/04/22 13.13 by Iga Noviyanti
 */
@OptIn(ExperimentalPagingApi::class)
class ListRecipePagingSource @Inject constructor(
    private val service: RecipeAPI
    ) : RxPagingSource<Int, ListRecipesResult.RecipeItem>() {

        override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ListRecipesResult.RecipeItem>> {
            val position = params.key ?: 0

            return service.getRecipesPagination(position, 20)
                .subscribeOn(Schedulers.io())
                .map { toLoadResult(it, position) }
                .onErrorReturn { LoadResult.Error(it) }
        }

        private fun toLoadResult(data: ListRecipesResult, position: Int): LoadResult<Int, ListRecipesResult.RecipeItem> {
            return LoadResult.Page(
                data = data.results.orEmpty(),
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == data.count) null else position + 1
            )
        }

    override fun getRefreshKey(state: PagingState<Int, ListRecipesResult.RecipeItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPageIndex = state.pages.indexOf(state.closestPageToPosition(anchorPosition))
            state.pages.getOrNull(anchorPageIndex + 1)?.prevKey ?: state.pages.getOrNull(anchorPageIndex - 1)?.nextKey
        }
    }
}