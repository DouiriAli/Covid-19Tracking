package com.health.data.entity

import com.google.gson.annotations.SerializedName

data class CountryEntity(
    @SerializedName("country")
    val country: String = "",

    @SerializedName("countryInfo")
    val countryInfo: CountryInfoEntity,

    @SerializedName("cases")
    val cases: Long = 0L,

    @SerializedName("todayCases")
    val todayCases: Long = 0L,

    @SerializedName("deaths")
    val deaths: Long = 0L,

    @SerializedName("todayDeaths")
    val todayDeaths: Long = 0L,

    @SerializedName("recovered")
    val recovered: Long = 0L,

    @SerializedName("active")
    val active: Long = 0L,

    @SerializedName("critical")
    val critical: Long = 0L,

    @SerializedName("casesPerOneMillion")
    val casesPerOneMillion: Double = 0.0,

    @SerializedName("deathsPerOneMillion")
    val deathsPerOneMillion: Double = 0.0,

    @SerializedName("updated")
    val updated: Long = 0L
)