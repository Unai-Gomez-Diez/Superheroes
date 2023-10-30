package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.app.left
import com.ugdgomezdiez.superheroes.app.right

class GetSuperHeroeUseCase(
    private val superHeroeRepository: SuperHeroeRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository
) {
    suspend operator fun invoke(id: Int):Either<ErrorApp,SuperHeroe> {
        return try {
            SuperHeroe(
                superHeroeRepository.findSuperHeroe(id).get(),
                workRepository.findWork(id).get(),
                biographyRepository.findBiography(id).get()
            ).right()
        }catch (e: Exception){
            return ErrorApp.UnknowError.left()
        }
    }
}