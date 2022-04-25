/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.network

import com.dana.onboardingproject.listrecipe.repository.source.network.result.ListRecipesResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Iga Noviyanti created on 18/04/22 at 11.09
 */

interface RecipeAPI {

    @GET(Constant.Network.Endpoint.LIST_RECIPE)
    fun getRecipes(
        @Query("from") from: Int,
        @Query("size") size: Int,
        @Query("tags") tags: String? = "under_30_minutes"
    ): Observable<ListRecipesResult>

}