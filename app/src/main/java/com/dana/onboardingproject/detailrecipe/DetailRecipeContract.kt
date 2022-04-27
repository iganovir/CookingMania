/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.detailrecipe

import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.base.BasePresenter
import com.dana.onboardingproject.base.BaseView


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipeContract, v 0.1 26/04/22 15.40 by Iga Noviyanti
 */
interface DetailRecipeContract {
    interface Presenter : BasePresenter {
        fun getDetailRecipe(id: Int)
        fun addToCookLater(recipe: Recipe)
        fun deleteFromCookLater(recipe: Recipe)
    }

    interface View : BaseView {
        fun setDetailRecipe(recipe: Recipe)
        fun setDataIsAddedToCookLater(isAdded: Boolean)
    }
}