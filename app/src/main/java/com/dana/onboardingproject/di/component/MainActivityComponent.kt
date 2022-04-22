package com.dana.onboardingproject.di.component

import com.dana.onboardingproject.examplemain.MainActivity
import com.dana.onboardingproject.di.MainActivityModule
import com.dana.onboardingproject.di.PerActivity
import dagger.Component


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version MainActivityComponent, v 0.1 21/04/22 13.01 by Iga Noviyanti
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}