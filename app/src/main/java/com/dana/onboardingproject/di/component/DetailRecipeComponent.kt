/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.di.component

import com.dana.onboardingproject.detailrecipe.DetailRecipeActivity
import com.dana.onboardingproject.di.PerActivity
import com.dana.onboardingproject.di.module.DetailRecipeModule
import dagger.Component


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version DetailRecipeModule, v 0.1 26/04/22 16.13 by Iga Noviyanti
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [DetailRecipeModule::class]
)
interface DetailRecipeComponent {
    fun inject(activity: DetailRecipeActivity)
}