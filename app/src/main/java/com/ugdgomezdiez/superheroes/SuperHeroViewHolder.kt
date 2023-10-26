package com.ugdgomezdiez.superheroes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ugdgomezdiez.superheroes.app.extensions.setUrl
import com.ugdgomezdiez.superheroes.databinding.ViewSuperheroItemBinding
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class SuperHeroViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewSuperheroItemBinding

    fun bind(model: SuperHeroe){
        binding = ViewSuperheroItemBinding.bind(view)

        binding.apply {
            image.setUrl(model.image.sm)
            name.text=model.name
        }
    }
}