package com.ugdgomezdiez.superheroes.domain

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases:List<String>,
    val placeOfBirth: String,
    val publisher: String,
    val alignment: String
)
