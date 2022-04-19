package com.dana.domain.usecase

import com.dana.domain.repository.RecipeRepository
import io.reactivex.Observable
import javax.inject.Inject

//interface ExampleBaseUseCase : BaseUseCase<BaseModel, ExampleUseCase.Params>

class GetRecipesListUseCase @Inject constructor(private val repository: RecipeRepository):
    BaseUseCase<GetRecipesListUseCase.Params, Int>() {

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