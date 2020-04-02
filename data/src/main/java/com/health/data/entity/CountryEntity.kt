package com.health.data.entity

import com.google.gson.annotations.SerializedName

data class CountryEntity(
    @SerializedName("country")
    val country: String,

    @SerializedName("countryInfo")
    val countryInfo: CountryInfoEntity,

    @SerializedName("cases")
    val cases: Long,

    @SerializedName("todayCases")
    val todayCases: Long,

    @SerializedName("deaths")
    val deaths: Long,

    @SerializedName("todayDeaths")
    val todayDeaths: Long,

    @SerializedName("recovered")
    val recovered: Long,

    @SerializedName("active")
    val active: Long,

    @SerializedName("critical")
    val critical: Long,

    @SerializedName("casesPerOneMillion")
    val casesPerOneMillion: Double,

    @SerializedName("deathsPerOneMillion")
    val deathsPerOneMillion: Double,

    @SerializedName("updated")
    val updated: Long
)