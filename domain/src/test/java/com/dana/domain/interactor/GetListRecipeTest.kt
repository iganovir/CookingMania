/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.domain.interactor

import com.dana.domain.base.BaseTest
import com.dana.domain.helper.MockData
import com.dana.domain.listrecipe.interactor.GetDetailRecipe
import com.dana.domain.listrecipe.interactor.GetListRecipe
import com.dana.domain.listrecipe.repository.RecipeRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version GetListRecipeTest, v 0.1 25/04/22 07.59 by Iga Noviyanti
 */


class GetListRecipeTest : BaseTest() {
    private var recipeRepository = mockk<RecipeRepository>(relaxed = true)
    private var getListRecipe = GetListRecipe(recipeRepository)
    private var getDetailRecipe = GetDetailRecipe(recipeRepository)

    @Test
    fun `getListRecipe Interactor`() {
        val params = GetListRecipe.Params(
            from = 0,
            size = 2
        )
        val resultListRecipe = MockData.mockRecipe
        //given
        every { recipeRepository.getListRecipe(0, 2) } returns Observable.just(
            resultListRecipe
        )
        //when
        getListRecipe.buildUseCase(params)
        //then
        verify { recipeRepository.getListRecipe(0, 2) }
    }

    @Test
    fun `getDetailRecipe Interactor`() {
        val params = GetDetailRecipe.Params(
            id = 1234
        )
        val detailRecipe = MockData.mockRecipe[0]
        //given
        every { recipeRepository.getDetailRecipe(1234) } returns Observable.just(
            detailRecipe
        )
        //when
        getDetailRecipe.buildUseCase(params)
        //then
        verify { recipeRepository.getDetailRecipe(1234) }
    }

    @After
    fun tearDown() {
        getListRecipe.dispose()
    }
}