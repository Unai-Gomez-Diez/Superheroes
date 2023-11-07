package com.ugdgomezdiez.superheroes.app.api

import com.ugdgomezdiez.superheroes.domain.BiographyModel
import com.ugdgomezdiez.superheroes.domain.SuperHeroeListModel
import com.ugdgomezdiez.superheroes.domain.WorkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("heroes.json")
    suspend fun getHeroes(): Response<List<SuperHeroeListModel>>

    @GET("heroes./{id}.json")
    suspend fun getHeroe(@Path("id") id: Int): Response<SuperHeroeListModel>

    @GET("biography/{id}.json")
    suspend fun getBiography(@Path("id") id: Int): Response<BiographyModel>

    @GET("work/{id}.json")
    suspend fun getWork(@Path("id") id: Int): Response<WorkModel>
}