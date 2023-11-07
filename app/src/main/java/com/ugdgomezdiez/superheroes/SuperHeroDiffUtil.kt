package com.ugdgomezdiez.superheroes

import androidx.recyclerview.widget.DiffUtil
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.SuperHeroeList

class SuperHeroDiffUtil: DiffUtil.ItemCallback<SuperHeroe>() {
    override fun areItemsTheSame(oldItem: SuperHeroe, newItem: SuperHeroe): Boolean {
        return oldItem.superHeroeList.id == newItem.superHeroeList.id
    }

    override fun areContentsTheSame(oldItem: SuperHeroe, newItem: SuperHeroe): Boolean {
        return oldItem == newItem
    }
}