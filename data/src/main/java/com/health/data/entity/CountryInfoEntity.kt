package com.health.data.entity

import com.google.gson.annotations.SerializedName

data class CountryInfoEntity(
    @SerializedName("_id")
    val id: Int,

    @SerializedName("iso2")
    val iso2: String? = null,

    @SerializedName("iso3")
    val iso3: String? = null,

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("long")
    val long: Double,

    @SerializedName("flag")
    val flag: String
)