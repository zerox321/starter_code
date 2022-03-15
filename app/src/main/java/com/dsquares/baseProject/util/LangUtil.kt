@file:Suppress("DEPRECATION")

package com.dsquares.baseProject.util

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.N_MR1
import java.util.*


object LangUtil {


    fun Activity.setLanguage(language: String) {
        val locale = Locale(language)

        val configuration: Configuration = resources.configuration
        Locale.setDefault(locale)
        configuration.setLocale(locale)
        if (SDK_INT >= N_MR1) {
            applicationContext.createConfigurationContext(configuration)
            createConfigurationContext(configuration)
        }
        resources.updateConfiguration(configuration, resources.displayMetrics)
        onConfigurationChanged(configuration)
    }
}
