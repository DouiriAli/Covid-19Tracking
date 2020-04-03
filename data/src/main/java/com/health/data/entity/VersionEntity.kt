package com.health.data.entity

import com.google.gson.annotations.SerializedName

data class VersionEntity(
    @SerializedName("number")
    val number: Int,

    @SerializedName("message")
    val message: String
)