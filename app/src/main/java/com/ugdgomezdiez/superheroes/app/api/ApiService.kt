package com.ugdgomezdiez.superheroes.app.api

import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("heroes.json")
    suspend fun getHeroes(): Response<List<SuperHeroeModel>>
}