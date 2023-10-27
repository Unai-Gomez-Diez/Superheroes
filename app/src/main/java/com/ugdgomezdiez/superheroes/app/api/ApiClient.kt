package com.ugdgomezdiez.superheroes.app.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    var retrofit = Retrofit.Builder()
        .baseUrl("https://dam.sitehub.es/api-curso/superheroes/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    var apiService: ApiService = retrofit.create(ApiService::class.java)
}