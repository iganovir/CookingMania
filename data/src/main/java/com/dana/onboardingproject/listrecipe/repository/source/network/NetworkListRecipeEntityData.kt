/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source.network

import com.dana.onboardingproject.listrecipe.mapper.toEntity
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityData
import com.dana.onboardingproject.network.RecipeAPI
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version NetworkRecipe, v 0.1 22/04/22 10.44 by Iga Noviyanti
 */
class NetworkListRecipeEntityData @Inject constructor(
    private val recipeAPI: RecipeAPI
) : RecipeEntityData {

    override fun listRecipe(from: Int, size: Int): Observable<List<RecipeEntity>> {
        return recipeAPI.getRecipes(from = from, size = size).map {response ->
            response.results?.map { recipeItem ->
                recipeItem.toEntity()
            }
        }
    }
}