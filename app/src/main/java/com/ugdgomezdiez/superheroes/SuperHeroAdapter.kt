package com.ugdgomezdiez.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class SuperHeroAdapter: RecyclerView.Adapter<SuperHeroViewHolder>() {

    private val dataList: MutableList<SuperHeroe> = mutableListOf()

    fun setDataList(superHeroes: List<SuperHeroe>){
        dataList.clear()
        addDataList(superHeroes)
    }

    fun addDataList(superHeroes: List<SuperHeroe>){
        dataList.addAll(superHeroes)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_superhero_item, parent,false)
        return SuperHeroViewHolder(view)
    }

    override fun getItemCount(): Int =dataList.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind((dataList[position]))
    }
}