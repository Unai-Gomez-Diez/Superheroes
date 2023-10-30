package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp

class GetSuperHeroeListUseCase(private val repository: SuperHeroeRepository) {
    suspend operator fun invoke():Either<ErrorApp,List<SuperHeroeList>>{
        return repository.findSuperHeroeList()
    }
}