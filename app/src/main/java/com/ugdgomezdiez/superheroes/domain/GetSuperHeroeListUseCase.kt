package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.app.left
import com.ugdgomezdiez.superheroes.app.right

class GetSuperHeroeListUseCase(private val superHeroeRepository: SuperHeroeRepository,
                               private val biographyRepository: BiographyRepository,
                               private val workRepository: WorkRepository) {
    suspend operator fun invoke():Either<ErrorApp,List<SuperHeroe>>{
        return try {
            val superHeroList: MutableList<SuperHeroe> = mutableListOf()
            val result=superHeroeRepository.findSuperHeroeList()
            result.map {
                it.map {
                    val biography=biographyRepository.findBiography(it.id).get()
                    val work = workRepository.findWork(it.id).get()
                    superHeroList.add(SuperHeroe(it, work, biography))
                }

            }
            superHeroList.right()
        }catch (e: Exception){
            return ErrorApp.UnknowError.left()
        }
    }
}