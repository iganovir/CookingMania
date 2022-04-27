/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source.local.dao

import androidx.room.*
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.network.Constant
import io.reactivex.Observable


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeDao, v 0.1 27/04/22 16.04 by Iga Noviyanti
 */
@Dao
interface RecipeDao {

    @Query("SELECT * FROM ${Constant.Local.Database.Table.Recipes}")
    fun getListCookLater(): List<RecipeEntity>

    @Query("SELECT * FROM ${Constant.Local.Database.Table.Recipes} WHERE id = :idRecipe")
    fun getDetailRecipe(idRecipe : Int): RecipeEntity?

    @Update
    fun updateUser(user: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipe: RecipeEntity): Long

    @Delete
    fun deleteRecipe(recipe: RecipeEntity)
}