package com.dana.domain.usecase

import com.dana.domain.data.model.BaseModel
import com.dana.domain.repository.BaseRepository

interface ExampleBaseUseCase : BaseUseCase<BaseModel, ExampleUseCase.Params>

class ExampleUseCase(private val repository: BaseRepository): ExampleBaseUseCase {

    override suspend fun build(params: Params?): BaseModel {
//        return params?.let {
//            repository.getExample(exampleId = it.example)
//        } ?: throw RuntimeException(
//            "${ExampleUseCase::class.java.simpleName} param not available"
//        )

        return BaseModel()
    }

    data class Params(
        val example: String
    )
}