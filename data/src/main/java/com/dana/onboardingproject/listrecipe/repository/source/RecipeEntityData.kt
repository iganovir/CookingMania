/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source

import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import io.reactivex.Observable

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeEntityData, v 0.1 22/04/22 10.37 by Iga Noviyanti
 */
interface RecipeEntityData : RecipeEntityDataRemote, RecipeEntityDataLocal

interface RecipeEntityDataRemote {
    fun listRecipe(from : Int, size: Int) : Observable<List<RecipeEntity>>
    fun detailRecipe(id: Int) : Observable<RecipeEntity>
}

interface RecipeEntityDataLocal {
    fun listRecipeLocal(from : Int, size: Int) : List<RecipeEntity>
    fun detailRecipeLocal(id: Int) : RecipeEntity?
    fun addRecipeToCookLater(recipe: RecipeEntity) : Long
    fun deleteRecipeFromCooklater(recipe: RecipeEntity)
}