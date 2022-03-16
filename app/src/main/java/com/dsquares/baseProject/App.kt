package com.dsquares.baseProject

import android.app.Application
import android.app.NotificationManager
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.dsquares.baseProject.initializer.NotificationsInitializer.buildNotificationsInitializer
import com.dsquares.baseProject.initializer.RemoteConfigInitializer.buildRemoteConfigInitializer
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class App : Application(), ImageLoaderFactory {
    @Inject
    lateinit var loader: ImageLoader
    @Inject
    lateinit var firebaseMessaging: FirebaseMessaging
    @Inject
    lateinit var notificationManager: NotificationManager
    @Inject
    lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreate() {
        super.onCreate()
        buildNotificationsInitializer(
            firebaseMessaging = firebaseMessaging,
            notificationManager = notificationManager
        )
        buildRemoteConfigInitializer(remoteConfig = remoteConfig)

    }


    override fun newImageLoader(): ImageLoader = loader

}