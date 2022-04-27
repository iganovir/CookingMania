/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Rights Reserved.
 */

package com.dana.onboardingproject.detailrecipe.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.dana.domain.listrecipe.model.Instruction
import com.dana.onboardingproject.R
import com.dana.onboardingproject.databinding.ItemCookingInstructionBinding


/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version InstructionViewHolder, v 0.1 27/04/22 12.04 by Iga Noviyanti
 */
class InstructionViewHolder (private val binding: ItemCookingInstructionBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Instruction, position: Int) {
        with(binding) {
            tvRecipeInstruction.text = item.displayText
            tvRecipeInstructionNumber.text = root.context.getString(R.string.cooking_instruction_position, position+1)
        }

    }
}