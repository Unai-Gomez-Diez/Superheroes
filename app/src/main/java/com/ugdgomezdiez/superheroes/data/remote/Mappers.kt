package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.SuperHeroeModel

fun SuperHeroeModel.toModel(): SuperHeroe=
    SuperHeroe(this.id,this.name,this.images)