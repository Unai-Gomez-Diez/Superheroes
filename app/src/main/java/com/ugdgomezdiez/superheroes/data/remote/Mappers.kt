package com.ugdgomezdiez.superheroes.data.remote

import com.ugdgomezdiez.superheroes.domain.SuperHeroe

fun SuperHeroeModel.toModel(): SuperHeroe=
    SuperHeroe(this.id,this.name,this.slug,this.powerStats.toModel(),this.appearance.toModel(),this.images.toModel())

fun SuperHeroeModel.PowerStats.toModel(): SuperHeroe.Powerstats=
    SuperHeroe.Powerstats(this.intelligence,this.strength,this.speed,this.durability,this.power,this.combat)

fun SuperHeroeModel.Appearance.toModel():SuperHeroe.Appearance=
    SuperHeroe.Appearance(this.gender,this.race,this.height,this.weight,this.eyeColor,this.hairColor)
fun SuperHeroeModel.Images.toModel(): SuperHeroe.Images=
    SuperHeroe.Images(this.xs,this.sm,this.md,this.lg)
