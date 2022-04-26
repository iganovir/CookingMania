/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.data.helper

import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.model.RecipeEntity


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version MockData, v 0.1 25/04/22 08.12 by Iga Noviyanti
 */
object MockData {
    val mockRecipe = listOf(
        RecipeEntity(
            id = 1234,
            name = "Martabak",
            thumbnail = "here-is-thumbnail.id/1234",
            cookTimeMinutes = "3",
            numServing = 4,
            description = "Ini adalah mock data untuk recipe"
        ),
        RecipeEntity(
            id = 1235,
            name = "Martabak-2",
            thumbnail = "here-is-thumbnail.id/12345",
            cookTimeMinutes = "3",
            numServing = 4,
            description = "Ini adalah mock data untuk recipe-2"
        )
    )

    val from = 0

    val size = 2
}