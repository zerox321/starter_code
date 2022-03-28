package com.dsquares.baseProject.initializer

import android.content.Context
import com.dsquares.baseProject.BuildConfig.VERSION_CODE
import com.dsquares.baseProject.presentation.util.ActivityLauncher.launchUpdatesActivity
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import timber.log.Timber

object RemoteConfigInitializer {


    fun Context.buildRemoteConfigInitializer(remoteConfig: FirebaseRemoteConfig) {
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) return@addOnCompleteListener
                val remoteVersionCode = remoteConfig.getLong("AndroidVersionCode")
                Timber.tag("FirebaseRemoteConfig code:").e(remoteVersionCode.toString())
                if (remoteVersionCode > VERSION_CODE) launchUpdatesActivity()
            }
    }


}