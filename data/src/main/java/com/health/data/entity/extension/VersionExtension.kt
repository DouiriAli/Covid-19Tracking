package com.health.data.entity.extension

import com.health.data.entity.VersionEntity
import com.health.domain.model.Version

fun VersionEntity.transform(): Version = Version(
    number = number,
    message = message
)