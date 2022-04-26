/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.di.module

import com.dana.onboardingproject.di.PerActivity
import com.dana.onboardingproject.listrecipe.ListRecipeContract
import com.dana.onboardingproject.listrecipe.ListRecipePresenter
import dagger.Module
import dagger.Provides


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version MainActivityModule, v 0.1 20/04/22 11.40 by Iga Noviyanti
 */

@Module
class ListRecipeModule(
    private val view: ListRecipeContract.View
){

    @PerActivity
    @Provides
    fun provideRecipeListView(): ListRecipeContract.View = view

    @PerActivity
    @Provides
    fun provideRecipeListPresenter(
        presenter: ListRecipePresenter
    ): ListRecipeContract.Presenter = presenter
}