/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.data.repository

import com.dana.onboardingproject.data.helper.MockData
import com.dana.onboardingproject.listrecipe.paging.ListRecipePagingSource
import com.dana.onboardingproject.listrecipe.repository.RecipeEntityRepository
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityData
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityDataFactory
import com.google.common.truth.Truth
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
    private val localRepository = mockk<RecipeEntityData>()
    private val pagingSource = mockk<ListRecipePagingSource>()
    private val repository = RecipeEntityRepository(dataFactory, pagingSource)

    @Before
    fun setUp() {
        every { dataFactory.createRecipeEntityDataRemote() } returns remoteRepository
        every { dataFactory.createRecipeEntityDataLocal() } returns localRepository
    }

    @Test
    fun `getListRecipe with result size = 2 from remoteRepository#listRecipe`() {
        val recipeResult = MockData.mockRecipe
        //given
        every { remoteRepository.listRecipe(MockData.from, MockData.size) } returns Observable.just(recipeResult)
        //when
        repository.getListRecipe(MockData.from, MockData.size)
        //then
        verify(exactly = 1) { remoteRepository.listRecipe(MockData.from, MockData.size) }
        Truth.assertThat(remoteRepository.listRecipe(MockData.from, MockData.size)).isNotNull()
    }

    @Test
    fun `getDetailRecipe with id 1234`() {
        val recipeResult = MockData.mockRecipe[0]
        //given
        every { remoteRepository.detailRecipe(1234) } returns Observable.just(recipeResult)
        //when
        repository.getDetailRecipe(1234)
        //then
        verify(exactly = 1) { remoteRepository.detailRecipe(1234) }
    }

    @Test
    fun `getDetailRecipe with id 2222 return false`() {
        val recipeResult = MockData.mockRecipe[0]
        //given
        every { remoteRepository.detailRecipe(2222) } returns Observable.just(recipeResult)
        //when
        repository.getDetailRecipe(2222)
        //then
        Truth.assertThat(remoteRepository.detailRecipe(2222).isEmpty)
    }
}