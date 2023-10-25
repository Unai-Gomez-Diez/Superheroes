package com.ugdgomezdiez.superheroes.app.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://dam.sitehub.es/api-curso/superheroes/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService: ApiService = retrofit.create(ApiService::class.java)
}