/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.di.module

import com.dana.domain.DefaultDispatcher
import com.dana.onboardingproject.cooklater.CooklaterContract
import com.dana.onboardingproject.cooklater.CooklaterPresenter
import com.dana.onboardingproject.di.PerActivity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version CooklaterModule, v 0.1 27/04/22 21.29 by Iga Noviyanti
 */
@Module
class CooklaterModule(
    private val view: CooklaterContract.View
){
    @PerActivity
    @Provides
    fun provideCooklaterListView(): CooklaterContract.View = view

    @PerActivity
    @Provides
    fun provideCooklaterListPresenter(
        presenter: CooklaterPresenter
    ): CooklaterContract.Presenter = presenter

    @PerActivity
    @Provides
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.Default

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}