package com.ugdgomezdiez.superheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugdgomezdiez.superheroes.app.extensions.setUrl
import com.ugdgomezdiez.superheroes.data.remote.BiographyRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.WorkRemoteDataSource
import com.ugdgomezdiez.superheroes.databinding.ActivityHeroBinding
import com.ugdgomezdiez.superheroes.domain.GetSuperHeroeUseCase
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class SuperHeroeDetailActivity: AppCompatActivity() {
    lateinit var binding: ActivityHeroBinding

    private val superHeroImageAdapter= SuperHeroImageAdapter()
    private val viewModel: SuperHeroImageViewModel by lazy {
        SuperHeroImageViewModel(
            GetSuperHeroeUseCase(
                SuperHeroeRemoteDataSource(),
                BiographyRemoteDataSource(),
                WorkRemoteDataSource()
            )
        )
    }
    companion object {
        val HERO_ID_PARAM = "KEY_HERO_ID"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        val heroId = intent.extras?.getInt(HERO_ID_PARAM)
        setupObservers()
        setupView()
        if (heroId != null) {
            viewModel.loadSuperHeroe(heroId)
        }
    }


    private fun setupBinding(){
        binding = ActivityHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun setupView(){
        binding.apply {
            listImage.layoutManager=LinearLayoutManager(
                this@SuperHeroeDetailActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            listImage.adapter=superHeroImageAdapter
        }
    }

    private fun setupObservers(){
        val observer=Observer<SuperHeroImageViewModel.UiModel>{
            it.superHeroe?.let{
                bind(it)
            }
        }
        viewModel.uiModel.observe(this,observer)
    }

    private fun bind(superHeroe: SuperHeroe){
        binding.apply {
            nombreReal.text=superHeroe.biography.fullName
            descripcion.text=superHeroe.work.occupation
            nombreHeroe.text=superHeroe.superHeroeList.name
            imagenPrin.setUrl(superHeroe.superHeroeList.image.sm)
            buenomalo.text=superHeroe.biography.alignment
            inteligenciaValor.inputType=superHeroe.superHeroeList.powerStats.intelligence
            speedValor.inputType=superHeroe.superHeroeList.powerStats.speed
            combatValor.inputType=superHeroe.superHeroeList.powerStats.combat
        }
    }
}