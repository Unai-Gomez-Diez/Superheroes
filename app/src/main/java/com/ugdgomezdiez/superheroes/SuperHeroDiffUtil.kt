package com.ugdgomezdiez.superheroes

import androidx.recyclerview.widget.DiffUtil
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class SuperHeroDiffUtil: DiffUtil.ItemCallback<SuperHeroe>() {
    override fun areItemsTheSame(oldItem: SuperHeroe, newItem: SuperHeroe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHeroe, newItem: SuperHeroe): Boolean {
        return oldItem == newItem
    }
}