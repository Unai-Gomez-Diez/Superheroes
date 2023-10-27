package com.ugdgomezdiez.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class SuperHeroAdapter: ListAdapter<SuperHeroe, SuperHeroViewHolder>(SuperHeroDiffUtil()) {
    lateinit var onClick:(heroId: Int)->Unit
    fun setEvent(onClick: (Int)->Unit){
        this.onClick=onClick
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_superhero_item, parent,false)
        return SuperHeroViewHolder(view)
    }
    override fun getItemCount(): Int =currentList.size
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {

        holder.bind(currentList[position],onClick)

    }
}