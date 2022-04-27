/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.mapper

import com.dana.domain.listrecipe.model.Instruction
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.model.InstructionEntity
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.network.result.ListRecipesResult

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipeMapper, v 0.1 22/04/22 10.45 by Iga Noviyanti
 */
fun ListRecipesResult.RecipeItem.toDomain(): Recipe {
    val instructionsDomain = this.instructions?.map {
        it.toDomain()
    }.orEmpty()

    return Recipe(
        this.id,
        this.name,
        this.thumbnailUrl,
        this.cookTimeMinutes,
        this.numServings,
        this.description,
        instructionsDomain
    )
}

fun ListRecipesResult.RecipeItem.toEntity(): RecipeEntity {
    val instructionsEntity = this.instructions?.map {
        it.toEntity()
    }.orEmpty()

    return RecipeEntity(
        this.id,
        this.name,
        this.thumbnailUrl,
        this.cookTimeMinutes,
        this.numServings,
        this.description,
        instructionsEntity
    )
}

fun ListRecipesResult.RecipeItem.Instruction.toDomain(): Instruction {
    return Instruction(
        this.appliance,
        this.displayText,
        this.endTime,
        this.id,
        this.position,
        this.startTime,
        this.temperature
    )
}

fun ListRecipesResult.RecipeItem.Instruction.toEntity(): InstructionEntity {
    return InstructionEntity(
        this.appliance,
        this.displayText,
        this.endTime,
        this.id,
        this.position,
        this.startTime,
        this.temperature
    )
}