package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp

interface BiographyRepository {
    suspend fun findBiography(id: Int): Either<ErrorApp, Biography>
}