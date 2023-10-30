package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp

interface SuperHeroeRepository {
    suspend fun findSuperHeroeList(): Either<ErrorApp, List<SuperHeroeList>>

    suspend fun findSuperHeroe(id: Int): Either<ErrorApp,SuperHeroeList>
}