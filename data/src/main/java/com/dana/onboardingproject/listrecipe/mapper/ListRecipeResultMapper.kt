/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.mapper

import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.network.result.ListRecipesResult

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipeMapper, v 0.1 22/04/22 10.45 by Iga Noviyanti
 */
fun ListRecipesResult.RecipeItem.toDomain(): Recipe {
    return Recipe(
        this.id,
        this.name,
        this.thumbnailUrl,
        this.cookTimeMinutes,
        this.numServings,
        this.description
    )
}

fun ListRecipesResult.RecipeItem.toEntity(): RecipeEntity {
    return RecipeEntity(
        this.id,
        this.name,
        this.thumbnailUrl,
        this.cookTimeMinutes,
        this.numServings,
        this.description
    )
}