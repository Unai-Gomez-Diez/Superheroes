package com.ugdgomezdiez.superheroes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ugdgomezdiez.superheroes.app.extensions.setUrl
import com.ugdgomezdiez.superheroes.databinding.ActivityHeroBinding
import com.ugdgomezdiez.superheroes.databinding.ViewHeroimageItemBinding
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class HeroImageViewHolder(val view:View): RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewHeroimageItemBinding

    fun bind(model:SuperHeroe){
        binding= ViewHeroimageItemBinding.bind(view)
        binding.apply {
          image.setUrl(model.image.sm)
        }
    }
}