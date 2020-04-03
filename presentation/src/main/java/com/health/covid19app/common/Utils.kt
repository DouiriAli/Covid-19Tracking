package com.health.covid19app.common

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.text.format.DateFormat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.health.covid19app.R
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

    fun timeInMillisToDate(timeInMillis: Long): String =
        DateFormat.format("dd-MM-yyyy", Date(timeInMillis)).toString()

    fun hasNetworkAvailable(context: Context): Boolean {
        val service = Context.CONNECTIVITY_SERVICE
        val manager = context.getSystemService(service) as ConnectivityManager?
        val network = manager?.activeNetworkInfo
        return (network != null)
    }

    fun openDialog(context: Context, message: String, listener: DialogListener) {
        MaterialAlertDialogBuilder(context)
            .setMessage(message)
            .setPositiveButton(context.getString(R.string.ok)) { dialog, _ ->
                listener.onClickPositiveButton()
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    interface DialogListener {
        fun onClickPositiveButton()
    }
}