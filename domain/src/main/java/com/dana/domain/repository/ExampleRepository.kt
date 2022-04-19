package com.dana.domain.repository

interface BaseRepository : BaseRemoteRepository, BaseCacheRepository

interface BaseRemoteRepository {
//    suspend fun getExample(exampleId: String) : BaseData
}

interface BaseCacheRepository