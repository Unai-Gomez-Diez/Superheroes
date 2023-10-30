package com.ugdgomezdiez.superheroes

import androidx.recyclerview.widget.DiffUtil
import com.ugdgomezdiez.superheroes.domain.SuperHeroeList

class SuperHeroDiffUtil: DiffUtil.ItemCallback<SuperHeroeList>() {
    override fun areItemsTheSame(oldItem: SuperHeroeList, newItem: SuperHeroeList): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHeroeList, newItem: SuperHeroeList): Boolean {
        return oldItem == newItem
    }
}