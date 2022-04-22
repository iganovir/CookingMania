/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source

import com.dana.onboardingproject.listrecipe.repository.source.mock.MockRecipeEntityData
import com.dana.onboardingproject.listrecipe.repository.source.network.NetworkListRecipeEntityData
import com.dana.onboardingproject.util.SourceType
import javax.inject.Inject

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipeFactory, v 0.1 22/04/22 11.25 by Iga Noviyanti
 */

class RecipeEntityDataFactory @Inject constructor(
    private val mockEntityData: MockRecipeEntityData,
    private val networkEntityData: NetworkListRecipeEntityData
) {

    fun createSearchUserEntityData(source: SourceType): RecipeEntityData =
        when (source) {
            SourceType.MOCK -> mockEntityData
            SourceType.NETWORK -> networkEntityData
        }

}