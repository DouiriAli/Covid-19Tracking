package com.health.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val countryName: String,

    val countryInfo: CountryInfo,

    val cases: Long,

    val todayCases: Long,

    val deaths: Long,

    val todayDeaths: Long,

    val recovered: Long,

    val active: Long,

    val critical: Long,

    val casesPerOneMillion: Double,

    val deathsPerOneMillion: Double,

    val updated: Long
) : Parcelable