package com.health.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val countryName: String = "",

    val countryInfo: CountryInfo? = null,

    val cases: Long = 0L,

    val todayCases: Long = 0L,

    val deaths: Long = 0L,

    val todayDeaths: Long = 0L,

    val recovered: Long = 0L,

    val active: Long = 0L,

    val critical: Long = 0L,

    val casesPerOneMillion: Double = 0.0,

    val deathsPerOneMillion: Double = 0.0,

    val updated: Long = 0L
) : Parcelable