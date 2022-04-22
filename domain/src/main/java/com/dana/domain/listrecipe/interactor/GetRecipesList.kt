package com.dana.domain.listrecipe.interactor

import com.dana.domain.listrecipe.repository.RecipeRepository
import com.dana.domain.base.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetRecipesList @Inject constructor(private val repository: RecipeRepository):
    BaseUseCase<GetRecipesList.Params, Int>() {

    override fun buildUseCase(params: Params): Observable<Int> {
        return params.let {
            repository.getListRecipe(from = it.from, size = it.size)
        }
    }

    data class Params(
        val from: Int,
        val size: Int
    )
}