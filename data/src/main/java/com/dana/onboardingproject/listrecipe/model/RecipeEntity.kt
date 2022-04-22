/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.model

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeEntity, v 0.1 22/04/22 10.40 by Iga Noviyanti
 */

data class RecipeEntity(
    var id: Int,
    val name: String?,
    val thumbnail: String?,
    val cookTimeMinutes: String?,
    val numServing: Int?,
    val description: String?
)