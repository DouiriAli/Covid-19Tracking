package com.health.data.entity.extension

import com.health.data.entity.CountryEntity
import com.health.data.entity.CountryInfoEntity
import com.health.domain.model.Country
import com.health.domain.model.CountryInfo

fun CountryEntity.transform(): Country = Country(
    country = country,
    countryInfo = countryInfo.transform(),
    cases = cases,
    todayCases = todayCases,
    deaths = deaths,
    todayDeaths = todayDeaths,
    recovered = recovered,
    active = active,
    critical = critical,
    casesPerOneMillion = casesPerOneMillion,
    deathsPerOneMillion = deathsPerOneMillion,
    updated = updated
)

fun CountryInfoEntity.transform(): CountryInfo = CountryInfo(
    id = id,
    iso2 = iso2,
    iso3 = iso3,
    lat = lat,
    long = long,
    flag = flag
)