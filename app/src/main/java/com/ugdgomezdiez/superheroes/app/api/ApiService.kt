package com.ugdgomezdiez.superheroes.app.api

import com.ugdgomezdiez.superheroes.data.remote.BiographyModel
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeModel
import com.ugdgomezdiez.superheroes.data.remote.WorkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("heroes.json")
    suspend fun getHeroes(): Response<List<SuperHeroeModel>>

    @GET("biography/{id}.json")
    suspend fun getBiography(@Path("id") id: Int): Response<BiographyModel>

    @GET("work/{id}.json")
    suspend fun getWork(@Path("id") id: Int): Response<WorkModel>
}