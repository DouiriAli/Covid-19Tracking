package com.health.domain.model

data class Country(
    val country: String,

    val countryInfo: CountryInfo,

    val cases: Int,

    val todayCases: Int,

    val deaths: Int,

    val todayDeaths: Int,

    val recovered: Int,

    val active: Int,

    val critical: Int,

    val casesPerOneMillion: Int,

    val deathsPerOneMillion: Int,

    val updated: Long
)