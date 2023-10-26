package com.ugdgomezdiez.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ugdgomezdiez.superheroes.app.api.ApiClient
import com.ugdgomezdiez.superheroes.data.remote.ApiRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private val viewModel: SuperHeroeViewModel by lazy {
        SuperHeroeViewModel(
            ApiRemoteDataSource(
                ApiClient()
            )
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadSuperHeroe()
    }


}