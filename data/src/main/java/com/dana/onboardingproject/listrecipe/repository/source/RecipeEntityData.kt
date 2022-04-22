/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source

import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import io.reactivex.Observable

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeEntityData, v 0.1 22/04/22 10.37 by Iga Noviyanti
 */
interface RecipeEntityData {

    fun listRecipe(from : Int, size: Int) : Observable<List<RecipeEntity>>
}