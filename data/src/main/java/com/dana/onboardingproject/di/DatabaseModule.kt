/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.di

import android.content.Context
import androidx.room.Room
import com.dana.onboardingproject.listrecipe.repository.source.local.dao.RecipeDao
import com.dana.onboardingproject.listrecipe.repository.source.local.db.RecipeDB
import com.dana.onboardingproject.network.Constant
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version DatabaseModule, v 0.1 27/04/22 15.44 by Iga Noviyanti
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        context: Context
    ) = Room.databaseBuilder(
        context,
        RecipeDB::class.java,
        Constant.Local.Database.NAME
    ).build()

    @Singleton
    @Provides
    fun provideRecipeDao(
        database: RecipeDB
    ): RecipeDao =
        database.recipesDao()
}