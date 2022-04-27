/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source

import com.dana.onboardingproject.listrecipe.repository.source.local.PersistenceRecipeEntityData
import com.dana.onboardingproject.listrecipe.repository.source.network.NetworkListRecipeEntityData
import com.dana.onboardingproject.util.SourceType
import javax.inject.Inject

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipeFactory, v 0.1 22/04/22 11.25 by Iga Noviyanti
 */

class RecipeEntityDataFactory @Inject constructor(
    private val persistenceEntityData: PersistenceRecipeEntityData,
    private val networkEntityData: NetworkListRecipeEntityData
) {

    fun createRecipeEntityDataRemote(): RecipeEntityDataRemote = networkEntityData
    fun createRecipeEntityDataLocal(): RecipeEntityDataLocal = persistenceEntityData

}