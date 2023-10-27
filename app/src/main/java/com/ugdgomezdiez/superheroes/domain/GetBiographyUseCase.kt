package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp

class GetBiographyUseCase(private val repository: BiographyRepository) {
    suspend operator fun invoke(id: Int): Either<ErrorApp, Biography> {
        return repository.findBiography(id)
    }
}