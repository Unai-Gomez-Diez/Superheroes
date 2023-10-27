package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.app.api.ApiClient
import com.ugdgomezdiez.superheroes.app.left
import com.ugdgomezdiez.superheroes.app.right
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.SuperHeroeRepository
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class ApiRemoteDataSource(private val apiClient: ApiClient): SuperHeroeRepository {

    override suspend fun findSuperHeroe(): Either<ErrorApp, List<SuperHeroe>> {



        return try {
            val response = apiClient.apiService.getHeroes()
            return if (response.isSuccessful) {
                //Listado
                val heroesList = response.body()!!.map {
                    it.toModel()
                }
                return heroesList.right()
            } else {
                ErrorApp.UnknowError.left()
            }
        }catch (e:TimeoutException) {
            ErrorApp.InternetError.left()
        }catch (e:UnknownHostException){
            ErrorApp.DataError.left()
        }catch (e:Exception){
            ErrorApp.UnknowError.left()
        }
    }
}