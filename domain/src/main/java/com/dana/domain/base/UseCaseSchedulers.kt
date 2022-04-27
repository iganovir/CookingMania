package com.dana.domain.base

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object UseCaseSchedulers {

    @JvmStatic
    val jobScheduler: Scheduler =
        Schedulers.io()

    @JvmStatic
    val postScheduler: Scheduler =
        AndroidSchedulers.mainThread()
}