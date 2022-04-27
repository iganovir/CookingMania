/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.detailrecipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dana.domain.listrecipe.model.Instruction
import com.dana.onboardingproject.databinding.ItemCookingInstructionBinding
import com.dana.onboardingproject.detailrecipe.viewholder.InstructionViewHolder


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version CookingInstructionAdapter, v 0.1 27/04/22 12.03 by Iga Noviyanti
 */
class CookingInstructionAdapter () :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<Instruction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return InstructionViewHolder(
            ItemCookingInstructionBinding.inflate(
                inflater,
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as InstructionViewHolder).onBind(items[position], position)

    }

    override fun getItemCount(): Int = items.size

    fun insertItems(instructions: List<Instruction>) {
        if (instructions != null && instructions.isNotEmpty()) {
            items.addAll(instructions)
            if (items.size - items.size == 0) {
                notifyDataSetChanged()
            } else {
                notifyItemRangeInserted(items.size - instructions.size, instructions.size)
            }
        }
    }

}