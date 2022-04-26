/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.databinding.ItemRecipeFooterLoadingBinding


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ItemLoadingViewHolder, v 0.1 25/04/22 15.44 by Iga Noviyanti
 */
class ItemLoadingViewHolder (private val binding: ItemRecipeFooterLoadingBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Recipe, callback: (recipe: Recipe) -> Unit) {

    }
}