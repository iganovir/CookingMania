/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.listrecipe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dana.domain.listrecipe.model.Recipe
import com.dana.onboardingproject.databinding.ItemRecipeBinding
import com.dana.onboardingproject.listrecipe.viewholder.RecipeItemViewHolder

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version RecipeAdapter, v 0.1 24/04/22 12.42 by Iga Noviyanti
 */
class RecipeAdapter (private val callback: (recipe: Recipe) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecipeItemViewHolder).onBind(items[position], callback)
    }

    override fun getItemCount(): Int = items.size

    fun insertItems(recipes: List<Recipe>){
        if (recipes != null && recipes.isNotEmpty()) {
            items.addAll(recipes)
            if (items.size - items.size == 0) {
                notifyDataSetChanged()
            } else {
                notifyItemRangeInserted(items.size - recipes.size, recipes.size)
            }
        }
    }

    private var onItemClickCallback: (view: View, item: Recipe) -> Unit = { _, _ -> }

    fun setOnItemClickListener(callback: (view: View, item: Recipe) -> Unit) {
        onItemClickCallback = callback
    }
}