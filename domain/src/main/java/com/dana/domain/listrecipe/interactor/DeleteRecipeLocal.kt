/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.domain.listrecipe.interactor

import com.dana.domain.listrecipe.model.Recipe
import com.dana.domain.listrecipe.repository.RecipeRepository
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version DeleteRecipeLocal, v 0.1 27/04/22 22.17 by Iga Noviyanti
 */
class DeleteRecipeLocal @Inject constructor(private val repository: RecipeRepository) {

    fun deleteRecipeFromCooklater(recipe: Recipe){
        repository.deleteRecipeFromCooklater(recipe)
    }
}