package com.dana.onboardingproject.di.component

import com.dana.onboardingproject.di.PerActivity
import com.dana.onboardingproject.di.module.ListRecipeModule
import com.dana.onboardingproject.listrecipe.ListRecipesActivity
import dagger.Component


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version MainActivityComponent, v 0.1 21/04/22 13.01 by Iga Noviyanti
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ListRecipeModule::class]
)
interface ListRecipeComponent {
    fun inject(activity: ListRecipesActivity)
}