package com.health.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryInfo(
    val id: Int = 0,

    val iso2: String? = null,

    val iso3: String? = null,

    val lat: Double = 0.0,

    val long: Double = 0.0,

    val flag: String = ""
) : Parcelable