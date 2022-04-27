/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source.local.converter

import androidx.room.TypeConverter
import com.dana.onboardingproject.listrecipe.model.InstructionEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken





/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeConverter, v 0.1 27/04/22 16.14 by Iga Noviyanti
 */
class RecipeConverter {
    @TypeConverter
    fun fromStringToInstructionEntity(value: String): List<InstructionEntity> {
        val listType = object : TypeToken<List<InstructionEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromInstructionEntityToString(instructions: List<InstructionEntity>): String {
        return if (instructions.isEmpty()) "" else Gson().toJson(instructions)
    }
}