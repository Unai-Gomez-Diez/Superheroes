package com.ugdgomezdiez.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ugdgomezdiez.superheroes.data.remote.BiographyRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.WorkRemoteDataSource
import com.ugdgomezdiez.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val viewModel: SuperHeroeViewModel by lazy {
        SuperHeroeViewModel(
            BiographyRemoteDataSource(),
            WorkRemoteDataSource(),
            SuperHeroeRemoteDataSource()
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        viewModel.loadSuperHeroe()
    }

    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupView(){
        binding.apply {
            list
        }
    }

}