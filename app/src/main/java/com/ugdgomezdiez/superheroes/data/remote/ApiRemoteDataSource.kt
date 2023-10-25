package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.app.api.ApiClient
import com.ugdgomezdiez.superheroes.app.api.ApiService
import com.ugdgomezdiez.superheroes.app.left
import com.ugdgomezdiez.superheroes.app.right
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.SuperHeroeModel
import com.ugdgomezdiez.superheroes.domain.SuperHeroeRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRemoteDataSource: SuperHeroeRepository {
    private val apiClient: ApiClient= ApiClient()
    override suspend fun findSuperHeroe(): Either<ErrorApp, SuperHeroe> {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl("https://dam.sitehub.es/api-curso/superheroes/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        var apiService: ApiService = retrofit.create(ApiService::class.java)

        return try{
            val response:Response<SuperHeroeModel> = apiClient.apiService.getHeroes()
            return if (response.isSuccessful){
                response.body()!!.toModel().right()
            }else{
                ErrorApp.UnknowError.left()
            }
        }catch (e:Exception){
            ErrorApp.UnknowError.left()
        }
    }
}