/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.local.converter.RecipeConverter
import com.dana.onboardingproject.listrecipe.repository.source.local.dao.RecipeDao


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeDB, v 0.1 27/04/22 16.03 by Iga Noviyanti
 */
@Database(entities = [RecipeEntity::class], version = 1, exportSchema = false)
@TypeConverters(RecipeConverter::class)
abstract class RecipeDB : RoomDatabase() {
    abstract fun recipesDao(): RecipeDao
}