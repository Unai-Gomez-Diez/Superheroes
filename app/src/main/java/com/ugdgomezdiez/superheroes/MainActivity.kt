package com.ugdgomezdiez.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ugdgomezdiez.superheroes.data.remote.BiographyRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeRemoteDataSource

class MainActivity : AppCompatActivity() {
    private val viewModel: SuperHeroeViewModel by lazy {
        SuperHeroeViewModel(
            BiographyRemoteDataSource(
            )
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadSuperHeroe()
    }


}