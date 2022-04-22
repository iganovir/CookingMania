package com.dana.onboardingproject.source.remote

import com.dana.onboardingproject.data.response.ListRecipesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Iga Noviyanti created on 18/04/22 at 11.09
 */

interface RecipeApi {

    @GET(Constant.Network.Endpoint.LIST_RECIPE)
    fun getRecipes(
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Observable<ListRecipesResponse>

}