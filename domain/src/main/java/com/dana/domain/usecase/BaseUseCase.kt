package com.dana.domain.usecase

interface BaseUseCase<Type : Any, in Params> {

    suspend fun build(params: Params?): Type
//
//    operator fun invoke(params: Params? = null) = flow {
//        emit(Result.Loading)
//        if (BuildConfig.DEBUG)//for loading delay dev only
//            delay(1000)
//        emit(Result.Success(build(params)))
//    }.flowOn(Dispatchers.IO).catch { exception ->
//        with(exception) {
//            printStackTrace()
//            emit(
//                Result.FailureWithException(
//                    errorCode = getErrorCode(),
//                    message = getErrorMessage(),
//                    data = getErrorData(),
//                    exception = exception
//                )
//            )
//        }
//    }
}