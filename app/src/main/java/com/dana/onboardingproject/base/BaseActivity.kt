/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dana.onboardingproject.CookingApp


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version BaseActivity, v 0.1 24/04/22 13.28 by Iga Noviyanti
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    protected abstract fun setupData(savedInstanceState: Bundle?)
    protected abstract fun initializeView(binding: T)
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setViewBinding()
        initializeView(binding = binding)
        setContentView(binding.root)
        setupData(savedInstanceState)
    }

    protected fun getApplicationComponent() = (application as CookingApp).getApplicationComponent()

    abstract fun setViewBinding(): T
}