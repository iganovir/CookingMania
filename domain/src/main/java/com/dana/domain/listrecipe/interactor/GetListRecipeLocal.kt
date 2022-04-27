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
 * @version GetListRecipeLocal, v 0.1 27/04/22 21.19 by Iga Noviyanti
 */
class GetListRecipeLocal @Inject constructor(private val repository: RecipeRepository){
    fun getListRecipe(): List<Recipe> = repository.getListRecipeLocal()
}