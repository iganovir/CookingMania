/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.domain.listrecipe.interactor

import com.dana.domain.base.BaseUseCase
import com.dana.domain.listrecipe.model.Recipe
import com.dana.domain.listrecipe.repository.RecipeRepository
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version GetDetailRecipe, v 0.1 26/04/22 15.43 by Iga Noviyanti
 */
class GetDetailRecipe @Inject constructor(private val repository: RecipeRepository):
    BaseUseCase<GetDetailRecipe.Params, Recipe>() {

    override fun buildUseCase(params: Params): Observable<Recipe> {
        return params.let {
            repository.getDetailRecipe(id = it.id)
        }
    }

    data class Params(
        val id: Int
    )
}