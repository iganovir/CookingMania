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
 * @version ListRecipeEntityMapper, v 0.1 22/04/22 11.43 by Iga Noviyanti
 */
fun Recipe.toEntity(): RecipeEntity {
    val instructionsEntity = this.instructions?.map {
        it.toEntity()
    }

    return RecipeEntity(
        this.id,
        this.name,
        this.thumbnail,
        this.cookTimeMinutes,
        this.numServing,
        this.description,
        instructionsEntity
    )
}

fun RecipeEntity.toDomain(): Recipe {
    val instructions = this.instructions?.map {
        it.toDomain()
    }.orEmpty()
    return Recipe(
        this.id,
        this.name,
        this.thumbnail,
        this.cookTimeMinutes,
        this.numServing,
        this.description,
        instructions
    )
}

fun InstructionEntity.toDomain(): Instruction {
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

fun Instruction.toEntity(): InstructionEntity {
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