package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.app.api.ApiClient
import com.ugdgomezdiez.superheroes.app.api.ApiService
import com.ugdgomezdiez.superheroes.app.left
import com.ugdgomezdiez.superheroes.app.right
import com.ugdgomezdiez.superheroes.domain.Work
import com.ugdgomezdiez.superheroes.domain.WorkRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorkRemoteDataSource(private val apiClient: ApiClient): WorkRepository {
    override suspend fun findWork(id: Int): Either<ErrorApp, Work> {
        return try{
            val response=  apiClient.apiService.getWork(id)
            return if(response.isSuccessful){
                response.body()!!.toModel().right()
            }else{
                ErrorApp.UnknowError.left()
            }
        }catch (e: Exception){
            ErrorApp.UnknowError.left()
        }
    }
}