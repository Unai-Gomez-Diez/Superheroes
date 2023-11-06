package com.ugdgomezdiez.superheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugdgomezdiez.superheroes.app.extensions.setUrl
import com.ugdgomezdiez.superheroes.databinding.ActivityHeroBinding
import com.ugdgomezdiez.superheroes.domain.Biography
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.Work

class SuperHeroeDetailActivity: AppCompatActivity() {
    lateinit var binding: ActivityHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

        val heroId = intent.extras?.getInt(HERO_ID_PARAM)
    }

        companion object {
        val HERO_ID_PARAM = "KEY_HERO_ID"
    }
    private fun bindData(work: Work, biography: Biography, superHeroe: SuperHeroe){
        binding.apply {
            nombreHeroe.text=superHeroe.name
            imagenPrin.setUrl(superHeroe.image.sm)
            buenomalo.text=biography.alignment
        }
    }
}