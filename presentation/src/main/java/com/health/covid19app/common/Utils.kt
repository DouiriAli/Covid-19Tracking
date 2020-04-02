package com.health.covid19app.common

import android.content.Context
import android.os.Build
import java.util.*

object Utils {

    fun setLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            context.createConfigurationContext(configuration)
        }
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}