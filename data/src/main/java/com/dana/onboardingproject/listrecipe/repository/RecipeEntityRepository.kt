package com.dana.onboardingproject.listrecipe.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import androidx.paging.rxjava2.flowable
import com.dana.domain.listrecipe.model.Recipe
import com.dana.domain.listrecipe.repository.RecipeRepository
import com.dana.onboardingproject.listrecipe.mapper.toDomain
import com.dana.onboardingproject.listrecipe.mapper.toEntity
import com.dana.onboardingproject.listrecipe.model.RecipeEntity
import com.dana.onboardingproject.listrecipe.paging.ListRecipePagingSource
import com.dana.onboardingproject.listrecipe.repository.source.RecipeEntityDataFactory
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class RecipeEntityRepository @Inject constructor(
    private val repositoryFactory: RecipeEntityDataFactory,
    private val pagingSource: ListRecipePagingSource
) :
    RecipeRepository {

    private fun getRemoteRepository() =
        repositoryFactory.createRecipeEntityDataRemote()

    private fun getLocalRepository() =
        repositoryFactory.createRecipeEntityDataLocal()

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

    override fun getListRecipePagination(from: Int, size: Int): Flowable<PagingData<Recipe>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            pagingSourceFactory = { pagingSource }
        ).flowable
            .map { pagingData ->
                pagingData.map {
                    it.toDomain()
                }
            }
    }

    override fun getDetailRecipe(id: Int): Observable<Recipe> {
        return getRemoteRepository().detailRecipe(id = id)
            .map { recipe ->
                recipe.toDomain()
            }
    }

    override fun getDetailRecipeLocal(id: Int): Recipe? {
        return getLocalRepository().detailRecipeLocal(id)?.toDomain()
    }

    override fun addRecipeToCookLater(recipe: Recipe): Long {
        return getLocalRepository().addRecipeToCookLater(recipe = recipe.toEntity())
    }

    override fun getListRecipeLocal(): List<Recipe> {
        return getLocalRepository().listRecipeLocal(0, 0).map {
            it.toDomain()
        }
    }

    override fun deleteRecipeFromCooklater(recipe: Recipe) {
        getLocalRepository().deleteRecipeFromCooklater(recipe = recipe.toEntity())
    }
}