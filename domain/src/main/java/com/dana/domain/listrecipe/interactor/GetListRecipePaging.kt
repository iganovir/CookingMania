/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.domain.listrecipe.interactor

import androidx.paging.PagingData
import com.dana.domain.base.BaseUseCase
import com.dana.domain.base.BaseUseCasePagination
import com.dana.domain.listrecipe.model.Recipe
import com.dana.domain.listrecipe.repository.RecipeRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version GetListRecipePaging, v 0.1 25/04/22 13.35 by Iga Noviyanti
 */
class GetListRecipePaging @Inject constructor(private val repository: RecipeRepository):
    BaseUseCasePagination<GetListRecipePaging.Params, PagingData<Recipe>>() {

    data class Params(
        val from: Int,
        val size: Int
    )

    override fun buildUseCasePagination(params: GetListRecipePaging.Params): Flowable<PagingData<Recipe>> {
        return params.let {
            repository.getListRecipePagination(from = it.from, size = it.size)
        }
    }

}