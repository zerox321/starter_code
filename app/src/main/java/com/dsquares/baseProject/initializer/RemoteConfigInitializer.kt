package com.dsquares.baseProject.initializer

import android.content.Context
import com.dsquares.baseProject.BuildConfig.VERSION_CODE
import com.dsquares.baseProject.presentation.util.Toast.showToast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

@Suppress("unused")
object RemoteConfigInitializer {


    fun Context.buildRemoteConfigInitializer(
        remoteConfig: FirebaseRemoteConfig,
    ) {
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) return@addOnCompleteListener
                val remoteVersionCode = remoteConfig.getLong("AndroidVersionCode")
                if (remoteVersionCode > VERSION_CODE) {
                    showToast(message = "there is a new version of app ")
                }
            }


    }


}