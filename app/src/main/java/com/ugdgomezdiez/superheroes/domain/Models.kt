package com.ugdgomezdiez.superheroes.domain

import com.google.gson.annotations.SerializedName

class SuperHeroeModel(
    @SerializedName("id") val id:Int,
    @SerializedName("name")val name:String,
    @SerializedName("images") val images:Images

){
    data class Images(
        val xs: String,
        val sm: String,
        val md: String,
        val lg: String
    )
}