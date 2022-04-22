package com.dana.domain.base

typealias OnSuccessCallback<T> = (T) -> Unit

typealias OnErrorCallback = (Throwable) -> Unit

typealias OnCompleteCallback = () -> Unit

typealias OnCancelCallback = () -> Unit