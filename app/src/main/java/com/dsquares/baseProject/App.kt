package com.dsquares.baseProject

import android.app.Application
import android.app.NotificationManager
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.dsquares.baseProject.initializer.NotificationsInitializer.buildNotificationsInitializer
import com.google.firebase.messaging.FirebaseMessaging
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
    override fun onCreate() {
        super.onCreate()
        buildNotificationsInitializer(
            firebaseMessaging = firebaseMessaging,
            notificationManager = notificationManager
        )
    }


    override fun newImageLoader(): ImageLoader = loader

}