package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.domain.Biography
import com.ugdgomezdiez.superheroes.domain.BiographyModel
import com.ugdgomezdiez.superheroes.domain.SuperHeroeList
import com.ugdgomezdiez.superheroes.domain.SuperHeroeModel
import com.ugdgomezdiez.superheroes.domain.Work
import com.ugdgomezdiez.superheroes.domain.WorkModel

fun SuperHeroeModel.toModel(): SuperHeroeList=
    SuperHeroeList(this.id,this.name,this.slug,this.powerStats.toModel(),this.appearance.toModel(),this.images.toModel())

fun SuperHeroeModel.PowerStats.toModel(): SuperHeroeList.Powerstats=
    SuperHeroeList.Powerstats(this.intelligence,this.strength,this.speed,this.durability,this.power,this.combat)

fun SuperHeroeModel.Appearance.toModel():SuperHeroeList.Appearance=
    SuperHeroeList.Appearance(this.gender,this.race,this.height,this.weight,this.eyeColor,this.hairColor)
fun SuperHeroeModel.Images.toModel(): SuperHeroeList.Images=
    SuperHeroeList.Images(this.xs,this.sm,this.md,this.lg)

fun BiographyModel.toModel(): Biography=
    Biography(this.fullName,this.alterEgos,this.aliases,this.placeOfBirth,this.publisher,this.alignment)

fun WorkModel.toModel(): Work =
    Work(this.occupation,this.base)
