package com.health.data.entity

import com.google.gson.annotations.SerializedName

data class CountryInfoEntity(
    @SerializedName("_id")
    val id: Int,

    @SerializedName("iso2")
    val iso2: String,

    @SerializedName("iso3")
    val iso3: String,

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("long")
    val long: Double,

    @SerializedName("flag")
    val flag: Double
)