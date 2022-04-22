package com.dana.onboardingproject.listrecipe.repository

import com.dana.domain.listrecipe.model.Recipe
import com.dana.domain.listrecipe.repository.RecipeRepository
import com.dana.onboardingproject.listrecipe.mapper.toDomain
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityDataFactory
import com.dana.onboardingproject.util.SourceType
import io.reactivex.Observable
import javax.inject.Inject

class RecipeEntityRepository @Inject constructor(private val repositoryFactory: RecipeEntityDataFactory) :
    RecipeRepository {

    private fun getRemoteRepository() =
        repositoryFactory.createSearchUserEntityData(SourceType.NETWORK)

    override fun getListRecipe(
        from: Int, size: Int
    ): Observable<List<Recipe>> {
        return getRemoteRepository().listRecipe(from = from, size = size)
            .flatMap { recipes ->
                recipes.mapListToDomain()
            }
    }

    private fun List<RecipeEntity>.mapListToDomain() =
        Observable.fromIterable(this)
            .map { it.toDomain() }
            .toList()
            .toObservable()

}