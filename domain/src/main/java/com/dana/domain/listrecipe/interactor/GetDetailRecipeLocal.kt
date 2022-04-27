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
 * @version GetDetailRecipeLocal, v 0.1 27/04/22 20.43 by Iga Noviyanti
 */
class GetDetailRecipeLocal @Inject constructor(private val repository: RecipeRepository){
    fun getDetailRecipe(id : Int) : Recipe? = repository.getDetailRecipeLocal(id)
}