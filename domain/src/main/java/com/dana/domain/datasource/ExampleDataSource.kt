package com.dana.domain.datasource

import com.dana.domain.repository.BaseCacheRepository
import com.dana.domain.repository.BaseRemoteRepository
import com.dana.domain.repository.BaseRepository
import com.dana.domain.source.remote.RecipeApi

interface ExampleDataSource : BaseRepository {

    class Factory(_network: Lazy<Network>, _cache: Lazy<Cache>){
        val network by _network
        val cache by _cache
    }

    class Network(
        private val service : RecipeApi
    ) : BaseRemoteRepository {
//        override suspend fun getExample(exampleId: String): BaseData = service.getExample("example").body()?.data ?: BaseData()
    }

    class Cache(): BaseCacheRepository {
        // this class for cache or local repository
    }
}