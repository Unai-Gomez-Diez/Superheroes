package com.ugdgomezdiez.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class SuperHeroImageAdapter: RecyclerView.Adapter<SuperHeroImageViewHolder>()  {
    private val dataList: MutableList<SuperHeroe> = mutableListOf()
    fun setDataList(superHeroes: List<SuperHeroe>){
        dataList.clear()
        addDataList(superHeroes)
    }
    fun addDataList(superHeroes: List<SuperHeroe>){
        dataList.addAll(superHeroes)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_heroimage_item, parent,false)
        return SuperHeroImageViewHolder(view)
    }
    override fun getItemCount(): Int =3
    override fun onBindViewHolder(holder: SuperHeroImageViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}