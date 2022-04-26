/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.domain.base

import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version BaseUseCasePagination, v 0.1 25/04/22 13.38 by Iga Noviyanti
 */
abstract class BaseUseCasePagination <Params, T> () {

    private val disposable = CompositeDisposable()

    /**
     * Build observable use case.
     *
     * @param params Use [NoParams] if you don't mind to pass any parameter.
     */
    abstract fun buildUseCasePagination(params: Params): Flowable<T>

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
        buildUseCasePagination(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
            .observeOn(UseCaseSchedulers.postScheduler)
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
        buildUseCasePagination(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
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