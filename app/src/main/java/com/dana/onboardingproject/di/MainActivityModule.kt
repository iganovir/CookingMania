package com.dana.onboardingproject.di

import com.dana.onboardingproject.examplemain.MainActivityContract
import com.dana.onboardingproject.examplemain.MainActivityPresenter
import dagger.Module
import dagger.Provides


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version MainActivityModule, v 0.1 20/04/22 11.40 by Iga Noviyanti
 */

@Module
class MainActivityModule(
    private val view: MainActivityContract.View
){

    @PerActivity
    @Provides
    fun provideUserDetailView(): MainActivityContract.View = view

    @PerActivity
    @Provides
    fun provideUserDetailPresenter(
        presenter: MainActivityPresenter
    ): MainActivityContract.Presenter = presenter
}