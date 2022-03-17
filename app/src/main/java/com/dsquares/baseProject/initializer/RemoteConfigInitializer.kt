package com.dsquares.baseProject.initializer

import android.content.Context
import com.dsquares.baseProject.BuildConfig.VERSION_CODE
import com.dsquares.baseProject.presentation.util.ActivityLauncher.launchUpdatesActivity
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

object RemoteConfigInitializer {


    fun Context.buildRemoteConfigInitializer(
        remoteConfig: FirebaseRemoteConfig,
    ) {
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) return@addOnCompleteListener
                val remoteVersionCode = remoteConfig.getLong("AndroidVersionCode")
                if (remoteVersionCode > VERSION_CODE) {
                    launchUpdatesActivity()
                }
            }


    }


}