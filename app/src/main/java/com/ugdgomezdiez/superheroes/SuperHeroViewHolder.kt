package com.ugdgomezdiez.superheroes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ugdgomezdiez.superheroes.app.extensions.setUrl
import com.ugdgomezdiez.superheroes.databinding.ViewSuperheroItemBinding
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.SuperHeroeList

class SuperHeroViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewSuperheroItemBinding

    fun bind(model: SuperHeroe, onClick:(Int)->Unit){
        binding = ViewSuperheroItemBinding.bind(view)

        binding.apply {
            image.setUrl(model.superHeroeList.image.sm)
            name.text=model.superHeroeList.name
            descripcion.text=model.biography.fullName
            trabajo.text=model.work.occupation
        }
        view.setOnClickListener {
            onClick.invoke(model.superHeroeList.id)
        }
    }
}