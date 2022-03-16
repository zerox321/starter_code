package com.dsquares.baseProject.initializer

import android.content.Context
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import androidx.startup.Initializer
import com.dsquares.baseProject.BuildConfig
import timber.log.Timber


@Suppress("unused")
class StrictModeInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Timber.e("StrictModeInitializer create")

//        if (!BuildConfig.DEBUG) return
//        enableStrictMode()
    }

    private fun enableStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build()
        )

        StrictMode.setVmPolicy(
            VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}