package com.dana.onboardingproject.datasource

import com.dana.domain.repository.RecipeRepository
import com.dana.onboardingproject.source.remote.RecipeApi
import io.reactivex.Observable

interface RecipesDataSource : RecipeRepository {

    class Factory(_network: Lazy<Network>){
        val network by _network
    }

    class Network(
        private val service : RecipeApi
    ) : RecipeRepository {
        override fun getListRecipe(from: Int, size: Int): Observable<Int> = service.getRecipes(from = from, size = size).map {
            it.results?.size
        }
    }

//    class Cache(): GetListRecipeCacheRepository {
//        // this class for cache or local repository
//    }
}