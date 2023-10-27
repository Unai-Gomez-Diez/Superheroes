package com.ugdgomezdiez.superheroes.app.api

import com.ugdgomezdiez.superheroes.data.remote.BiographyApiModel
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeApiModel
import com.ugdgomezdiez.superheroes.data.remote.WorkApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("heroes.json")
    suspend fun getHeroes(): Response<List<SuperHeroeApiModel>>
    @GET("biography/{id}.json")
    suspend fun getBiography(@Path("id") id: Int): Response<BiographyApiModel>
    @GET("work/{id}.json")
    suspend fun getWork(@Path("id") id: Int): Response<WorkApiModel>
}