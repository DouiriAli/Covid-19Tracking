package com.health.data.entity

import com.google.gson.annotations.SerializedName

data class CountryInfoEntity(
    @SerializedName("_id")
    val id: Int = 0,

    @SerializedName("iso2")
    val iso2: String? = null,

    @SerializedName("iso3")
    val iso3: String? = null,

    @SerializedName("lat")
    val lat: Double = 0.0,

    @SerializedName("long")
    val long: Double = 0.0,

    @SerializedName("flag")
    val flag: String = ""
)