/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.base


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version BaseView, v 0.1 27/04/22 18.47 by Iga Noviyanti
 */
interface BaseView {
    fun setLoading(isLoading: Boolean)
    fun setErrorHandler(throwable: Throwable)
}