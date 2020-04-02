package com.health.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryInfo(
    val id: Int,

    val iso2: String? = null,

    val iso3: String? = null,

    val lat: Double,

    val long: Double,

    val flag: String
) : Parcelable