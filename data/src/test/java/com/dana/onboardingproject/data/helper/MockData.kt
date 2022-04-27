/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.data.helper

import com.dana.onboardingproject.listrecipe.model.InstructionEntity
import com.dana.onboardingproject.listrecipe.model.RecipeEntity


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version MockData, v 0.1 25/04/22 08.12 by Iga Noviyanti
 */
object MockData {
    val instructionEntity = InstructionEntity(
        appliance = "Appliance",
        displayText = "Kocok telur",
        endTime = 2002,
        id = 1,
        position = 2,
        startTime = 2003,
        temperature = "80C"
    )

    val instructions = listOf(instructionEntity, instructionEntity)

    val mockRecipe = listOf(
        RecipeEntity(
            id = 1234,
            name = "Martabak",
            thumbnail = "here-is-thumbnail.id/1234",
            cookTimeMinutes = "3",
            numServing = 4,
            description = "Ini adalah mock data untuk recipe",
            instructions = instructions
        ),
        RecipeEntity(
            id = 1235,
            name = "Martabak-2",
            thumbnail = "here-is-thumbnail.id/12345",
            cookTimeMinutes = "3",
            numServing = 4,
            description = "Ini adalah mock data untuk recipe-2",
            instructions = instructions
        )
    )

    val from = 0

    val size = 2
}