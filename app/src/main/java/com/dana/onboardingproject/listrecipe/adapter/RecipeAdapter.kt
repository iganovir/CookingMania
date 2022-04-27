/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.databinding.ItemRecipeBinding
import com.dana.onboardingproject.databinding.ItemRecipeFooterLoadingBinding
import com.dana.onboardingproject.listrecipe.viewholder.ItemLoadingViewHolder
import com.dana.onboardingproject.listrecipe.viewholder.ItemRecipeViewHolder

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeAdapter, v 0.1 24/04/22 12.42 by Iga Noviyanti
 */
class RecipeAdapter(private val callback: (recipe: Recipe) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_ITEM = 1
        const val TYPE_LOADING = 2
    }

    private val items = ArrayList<Recipe>()
    private var isLoading: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            TYPE_ITEM -> ItemRecipeViewHolder(
                ItemRecipeBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> ItemLoadingViewHolder(ItemRecipeFooterLoadingBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemRecipeViewHolder -> holder.onBind(items[position], callback)
            is ItemLoadingViewHolder -> holder.onBind(items[position], callback)
        }
    }

    override fun getItemCount(): Int = items.size

    fun insertItems(recipes: List<Recipe>) {
        if (recipes != null && recipes.isNotEmpty()) {
            items.addAll(recipes)
            if (items.size - items.size == 0) {
                notifyDataSetChanged()
            } else {
                notifyItemRangeInserted(items.size - recipes.size, recipes.size)
            }
        }
    }

    fun removeAllItems(){
        items.clear()
    }

    private fun hasExtraRow(): Boolean = isLoading

    fun showLoadingMoreData(
        isLoading: Boolean = false
    ) {
        this.isLoading = isLoading
        if(isLoading) notifyItemInserted(itemCount)
    }

    override fun getItemViewType(position: Int) =
        if (hasExtraRow() && position == itemCount-1) TYPE_LOADING else TYPE_ITEM

}