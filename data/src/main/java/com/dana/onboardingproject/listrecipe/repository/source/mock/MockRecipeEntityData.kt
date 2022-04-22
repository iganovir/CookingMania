/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source.mock

import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityData
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version MockRecipeEntityData, v 0.1 22/04/22 10.37 by Iga Noviyanti
 */
class MockRecipeEntityData @Inject constructor() : RecipeEntityData {

    override fun listRecipe(from: Int, size: Int): Observable<List<RecipeEntity>> {
        TODO("Not yet implemented")
    }
}