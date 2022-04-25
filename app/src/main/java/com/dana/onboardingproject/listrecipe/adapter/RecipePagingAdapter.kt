/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.listrecipe.viewholder.RecipeItemViewHolder


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipePagingAdapter, v 0.1 25/04/22 09.58 by Iga Noviyanti
 */
class RecipePagingAdapter (private val callback: (recipe: Recipe) -> Unit) : PagingDataAdapter<Recipe, RecipeItemViewHolder>(diffUtils) {

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
//        holder.onBind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        TODO("Not yet implemented")
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