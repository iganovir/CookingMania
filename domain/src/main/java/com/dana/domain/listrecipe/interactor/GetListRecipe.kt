package com.dana.domain.listrecipe.interactor

import com.dana.domain.listrecipe.repository.RecipeRepository
import com.dana.domain.base.BaseUseCase
import com.dana.domain.listrecipe.model.Recipe
import io.reactivex.Observable
import javax.inject.Inject

class GetListRecipe @Inject constructor(private val repository: RecipeRepository):
    BaseUseCase<GetListRecipe.Params, List<Recipe>>() {

    override fun buildUseCase(params: Params): Observable<List<Recipe>> {
        return params.let {
            repository.getListRecipe(from = it.from, size = it.size)
        }
    }

    data class Params(
        val from: Int,
        val size: Int
    )
}