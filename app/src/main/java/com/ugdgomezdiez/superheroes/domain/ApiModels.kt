package com.ugdgomezdiez.superheroes.domain

import com.google.gson.annotations.SerializedName

class SuperHeroeModel(
    @SerializedName("id") val id:Int,
    @SerializedName("name")val name:String,
    @SerializedName("slug")val slug: String? = null,
    @SerializedName("powerstats")val powerStats: PowerStats,
    @SerializedName("appearance")val appearance:Appearance,
    @SerializedName("images") val images:Images

){
    class PowerStats(
        @SerializedName("intelligence")val intelligence: Int,
        @SerializedName("strength")val strength: Int,
        @SerializedName("speed")val speed: Int,
        @SerializedName("durability")val durability: Int,
        @SerializedName("power")val power: Int,
        @SerializedName("combat")val combat: Int
    )

    class Appearance(
        @SerializedName("gender")val gender: String,
        @SerializedName("race")val race: String?,
        @SerializedName("height")val height: List<String>,
        @SerializedName("weight")val weight: List<String>,
        @SerializedName("eyeColor")val eyeColor: String,
        @SerializedName("hairColor")val hairColor: String
    )
    class Images(
        @SerializedName("xs")val xs: String,
        @SerializedName("sm")val sm: String,
        @SerializedName("md")val md: String,
        @SerializedName("lg")val lg: String
    )
}
class BiographyModel(
    @SerializedName("fullName")val fullName: String,
    @SerializedName("alterEgos")val alterEgos: String,
    @SerializedName("aliases")val aliases:List<String>,
    @SerializedName("placeOfBirth")val placeOfBirth: String,
    @SerializedName("publisher")val publisher: String,
    @SerializedName("aligment")val alignment: String
)