/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.model

import com.google.gson.annotations.SerializedName


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version InstructionEntity, v 0.1 27/04/22 11.38 by Iga Noviyanti
 */
data class InstructionEntity (
    val appliance: String?  = null,
    val displayText: String?  = null,
    val endTime: Int?  = null,
    val id: Int?  = null,
    val position: Int?  = null,
    val startTime: Int?  = null,
    val temperature: String? = null
)