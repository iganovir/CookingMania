package com.dana.domain.base

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action

/**
* This **auto-dispose** UseCase class helps you to avoid memory leak when you forget to dispose
* [Observable].
*
* * For [Single], use [SingleUseCase]
* * For [Observable], use [BaseUseCase]
*
* @author Anggrayudi Hardiannico A. (anggrayudi.hardiannico@dana.id)
* @version BaseUseCase.kt, v 0.0.1 2020-02-25 13:22 by Anggrayudi Hardiannico A.
* @see CancellableUseCase
* @see CompletableUseCase
*/
abstract class BaseUseCase<Params, T> () {

    private val disposable = CompositeDisposable()

    /**
     * Build observable use case.
     *
     * @param params Use [NoParams] if you don't mind to pass any parameter.
     */
    abstract fun buildUseCase(params: Params): Observable<T>

    @JvmOverloads
    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {}
    ) {
        execute(params, onSuccess, onError, null) {}
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback = {}
    ) {
        execute(params, onSuccess, onError, onComplete) {}
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback? = {},
        onDispose: Action = Action {}
    ) {
        print("test")
        buildUseCase(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
            .observeOn(UseCaseSchedulers.postScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
            }, {
                onError(it)
                dispose()
            }, {
                onComplete?.invoke()
                dispose()
            })
            .let { disposable.add(it) }
    }

    private fun getSubclassPath(): String =
        this.javaClass.asSubclass(this.javaClass).name ?: "Unknown"

    @JvmOverloads
    fun executeInBackground(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {}
    ) {
        executeInBackground(params, onSuccess, onError, null) {}
    }

    fun executeInBackground(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback? = {},
        onDispose: Action = Action {}
    ) {
        buildUseCase(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
            }, {
                onError(it)
                dispose()
            }, {
                onComplete?.invoke()
                dispose()
            })
            .let { disposable.add(it) }
    }

    fun dispose() {
        disposable.clear()
    }
}