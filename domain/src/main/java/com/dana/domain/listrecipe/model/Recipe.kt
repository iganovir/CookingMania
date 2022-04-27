package com.dana.domain.listrecipe.model

/**
 * @author Iga Noviyanti created on 22/04/22 at 09.51
 */
data class Recipe(
    var id: Int? = 0,
    val name: String? = "",
    val thumbnail: String? = "",
    val cookTimeMinutes: String? = "",
    val numServing: Int? = 0,
    val description: String? = "",
    val instructions: List<Instruction>? = emptyList()
)