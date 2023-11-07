package com.ugdgomezdiez.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ugdgomezdiez.superheroes.domain.SuperHeroeList

class SuperHeroImageAdapter: ListAdapter<String,SuperHeroImageViewHolder>(SuperHeroImageDiffUtil())  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_heroimage_item,parent,false)
        return SuperHeroImageViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: SuperHeroImageViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}