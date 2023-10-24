package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.SuperHeroeRepository

class ApiRemoteDataSource:SuperHeroeRepository {
    override suspend fun findSpuerHeroe(): Either<ErrorApp, SuperHeroe> {
        TODO("Not yet implemented")
    }
}