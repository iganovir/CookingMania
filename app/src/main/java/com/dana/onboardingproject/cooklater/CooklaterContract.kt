/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.cooklater

import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.base.BasePresenter
import com.dana.onboardingproject.base.BaseView


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version CooklaterContract, v 0.1 27/04/22 21.16 by Iga Noviyanti
 */
interface CooklaterContract {
    interface Presenter : BasePresenter {
        fun getListRecipes()
    }

    interface View : BaseView {
        fun setListRecipes(recipes: List<Recipe>)
    }
}

