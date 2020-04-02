package com.health.data.entity.mapper

import com.health.data.entity.CountryEntity
import com.health.data.entity.extension.transform
import com.health.domain.model.Country

class CountryMapper {

    fun transformCountryEntityCollection(countryEntityCollection: MutableList<CountryEntity>):
            MutableList<Country>? =
        countryEntityCollection.map { it.transform() }.toMutableList()
}