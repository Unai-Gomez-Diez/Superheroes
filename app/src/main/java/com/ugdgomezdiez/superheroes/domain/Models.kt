package com.ugdgomezdiez.superheroes.domain

import com.google.gson.annotations.SerializedName

class HeroeModel(
    @SerializedName("id") val id:Int,
    @SerializedName("name")val name:String,
    @SerializedName("images") val images:String
)