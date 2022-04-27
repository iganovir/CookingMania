/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe

import androidx.paging.PagingData
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.base.BaseView


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipeContract, v 0.1 24/04/22 23.39 by Iga Noviyanti
 */
interface ListRecipeContract {
    interface Presenter {
        fun getListRecipes(from: Int, size: Int? = 10)
    }

    interface View : BaseView {
        fun setListRecipes(recipes: List<Recipe>)
    }
}