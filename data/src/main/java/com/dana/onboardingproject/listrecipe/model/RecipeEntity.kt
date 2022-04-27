/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.model

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dana.onboardingproject.network.Constant

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeEntity, v 0.1 22/04/22 10.40 by Iga Noviyanti
 */
@Entity(tableName = Constant.Local.Database.Table.Recipes)
data class RecipeEntity(
    @PrimaryKey
    var id: Int? = 0,
    @ColumnInfo(defaultValue = "")
    @Nullable
    val name: String?,
    @ColumnInfo(defaultValue = "")
    @Nullable
    val thumbnail: String?,
    @ColumnInfo(defaultValue = "")
    @Nullable
    val cookTimeMinutes: String?,
    @ColumnInfo(defaultValue = "")
    @Nullable
    val numServing: Int?,
    @ColumnInfo(defaultValue = "")
    @Nullable
    val description: String?,
    @ColumnInfo(defaultValue = "")
    @Nullable
    val instructions: List<InstructionEntity>?
)