package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.domain.Biography
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.Work

fun SuperHeroeApiModel.toModel(): SuperHeroe=
    SuperHeroe(this.id,this.name,this.slug,this.powerStats.toModel(),this.appearance.toModel(),this.images.toModel())
fun SuperHeroeApiModel.PowerStatsApiModel.toModel(): SuperHeroe.Powerstats=
    SuperHeroe.Powerstats(this.intelligence,this.strength,this.speed,this.durability,this.power,this.combat)
fun SuperHeroeApiModel.AppearanceApiModel.toModel():SuperHeroe.Appearance=
    SuperHeroe.Appearance(this.gender,this.race,this.height,this.weight,this.eyeColor,this.hairColor)
fun SuperHeroeApiModel.ImagesApiModel.toModel(): SuperHeroe.Images=
    SuperHeroe.Images(this.xs,this.sm,this.md,this.lg)
fun BiographyApiModel.toModel(): Biography=
    Biography(this.fullName,this.alterEgos,this.aliases,this.placeOfBirth,this.publisher,this.alignment)
fun WorkApiModel.toModel(): Work =
    Work(this.occupation,this.base)
