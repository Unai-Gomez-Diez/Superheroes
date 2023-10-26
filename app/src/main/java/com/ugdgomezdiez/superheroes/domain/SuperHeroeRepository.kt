package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp

interface SuperHeroeRepository {
    suspend fun findSuperHeroe(): Either<ErrorApp, List<SuperHeroe>>
}