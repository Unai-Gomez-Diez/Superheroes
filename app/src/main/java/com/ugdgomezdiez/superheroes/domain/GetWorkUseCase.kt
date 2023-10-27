package com.ugdgomezdiez.superheroes.domain

import com.ugdgomezdiez.superheroes.app.Either
import com.ugdgomezdiez.superheroes.app.ErrorApp

class GetWorkUseCase(private val repository: WorkRepository) {
    suspend operator fun invoke(id:Int):Either<ErrorApp,Work>{
        return repository.findWork(id)
    }
}