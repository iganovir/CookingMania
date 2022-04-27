/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.di.component

import com.dana.onboardingproject.cooklater.CooklaterActivity
import com.dana.onboardingproject.di.PerActivity
import com.dana.onboardingproject.di.module.CooklaterModule
import dagger.Component


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version CooklaterComponent, v 0.1 27/04/22 21.29 by Iga Noviyanti
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [CooklaterModule::class]
)
interface CooklaterComponent {
    fun inject(activity: CooklaterActivity)
}