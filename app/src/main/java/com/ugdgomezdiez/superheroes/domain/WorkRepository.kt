package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp

interface WorkRepository {
    suspend fun findWork(id:Int): Either<ErrorApp, Work>
}