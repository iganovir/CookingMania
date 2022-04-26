/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.databinding.ItemRecipeBinding
import com.dana.onboardingproject.listrecipe.viewholder.ItemRecipeViewHolder


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipePagingAdapter, v 0.1 25/04/22 09.58 by Iga Noviyanti
 */
class RecipePagingAdapter: PagingDataAdapter<Recipe, ItemRecipeViewHolder>(diffUtils) {

    override fun onBindViewHolder(holderRecipe: ItemRecipeViewHolder, position: Int) {
//        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemRecipeViewHolder(ItemRecipeBinding.inflate(inflater, parent, false))
    }

    companion object {
        private val diffUtils = object : DiffUtil.ItemCallback<Recipe>() {
            override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem == newItem
            }
        }
    }
}