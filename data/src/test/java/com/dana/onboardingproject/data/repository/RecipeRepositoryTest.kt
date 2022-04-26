/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.data.repository

import com.dana.onboardingproject.data.helper.MockData
import com.dana.onboardingproject.listrecipe.repository.RecipeEntityRepository
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityData
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityDataFactory
import com.dana.onboardingproject.util.SourceType
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeRepositoryTest, v 0.1 25/04/22 08.12 by Iga Noviyanti
 */
class RecipeRepositoryTest {
    private val dataFactory = mockk<RecipeEntityDataFactory>()
    private val remoteRepository = mockk<RecipeEntityData>()
    private val repository = RecipeEntityRepository(dataFactory)

    @Before
    fun setUp() {
        every { dataFactory.createRecipeEntityData(SourceType.NETWORK) } returns remoteRepository
    }

    @Test
    fun `getListRecipe with result size = 2 shouldInvoke remoteRepository#listRecipe`() {
        val recipeResult = MockData.mockRecipe
        //given
        every { remoteRepository.listRecipe(MockData.from, MockData.size) } returns Observable.just(recipeResult)
        //when
        repository.getListRecipe(MockData.from, MockData.size)
        //then
        verify(exactly = 1) { remoteRepository.listRecipe(MockData.from, MockData.size) }
    }
}