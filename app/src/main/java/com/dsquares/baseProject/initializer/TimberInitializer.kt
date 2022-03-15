package com.dsquares.baseProject.initializer

import android.content.Context
import androidx.startup.Initializer
import com.dsquares.baseProject.BuildConfig
import timber.log.Timber

@Suppress("unused")
class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Timber.e("TimberInitializer create")

        if (!BuildConfig.DEBUG) return
        Timber.plant(Timber.DebugTree())
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
