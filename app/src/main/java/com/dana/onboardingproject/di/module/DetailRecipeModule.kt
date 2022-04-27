/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.di.module

import com.dana.domain.DefaultDispatcher
import com.dana.onboardingproject.detailrecipe.DetailRecipeContract
import com.dana.onboardingproject.detailrecipe.DetailRecipePresenter
import com.dana.onboardingproject.di.PerActivity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version DetailRecipeModule, v 0.1 26/04/22 15.41 by Iga Noviyanti
 */
@Module
class DetailRecipeModule (
    private val view: DetailRecipeContract.View
){

    @PerActivity
    @Provides
    fun provideDetailRecipeView(): DetailRecipeContract.View = view

    @PerActivity
    @Provides
    fun provideDetailRecipePresenter(
        presenter: DetailRecipePresenter
    ): DetailRecipeContract.Presenter = presenter

    @PerActivity
    @Provides
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.Default

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}