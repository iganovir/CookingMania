/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source.local

import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityData
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityDataLocal
import com.dana.onboardingproject.listrecipe.repository.source.local.dao.RecipeDao
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version PresistenceRecipeEntityData, v 0.1 27/04/22 16.08 by Iga Noviyanti
 */
class PersistenceRecipeEntityData @Inject constructor(
    private val recipeDao: RecipeDao
) : RecipeEntityDataLocal {

    override fun listRecipeLocal(from: Int, size: Int): List<RecipeEntity> {
        return recipeDao.getListCookLater()
    }

    override fun addRecipeToCookLater(recipe: RecipeEntity): Long {
        return recipeDao.insertRecipe(recipe)
    }

    override fun detailRecipeLocal(id: Int) : RecipeEntity?{
        return recipeDao.getDetailRecipe(id)
    }

    override fun deleteRecipeFromCooklater(recipe: RecipeEntity) {
        return recipeDao.deleteRecipe(recipe)
    }
}