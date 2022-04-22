/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.mapper

import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.model.RecipeEntity

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipeEntityMapper, v 0.1 22/04/22 11.43 by Iga Noviyanti
 */
fun Recipe.toEntity(): RecipeEntity {
    return RecipeEntity(
        this.id,
        this.name,
        this.thumbnail,
        this.cookTimeMinutes,
        this.numServing,
        this.description
    )
}

internal fun RecipeEntity.toDomain(): Recipe {
    return Recipe(
        this.id,
        this.name,
        this.thumbnail,
        this.cookTimeMinutes,
        this.numServing,
        this.description
    )
}