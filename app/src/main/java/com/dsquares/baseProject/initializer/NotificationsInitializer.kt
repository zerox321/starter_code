package com.dsquares.baseProject.initializer

import android.app.NotificationManager
import android.content.Context
import com.dsquares.baseProject.R
import com.dsquares.baseProject.fcm.NotificationChannel.buildNotificationChannel
import com.google.firebase.messaging.FirebaseMessaging
import timber.log.Timber

object NotificationsInitializer {


    fun Context.buildNotificationsInitializer(
        firebaseMessaging: FirebaseMessaging,
        notificationManager: NotificationManager,
    ) {
        notificationManager.buildNotificationChannel(
            channelId = getString(R.string.notification_channel_id),
            channelName = getString(R.string.notification_channel_id)
        )

        firebaseMessaging.isAutoInitEnabled = true
        firebaseMessaging.token.addOnSuccessListener { token ->
            Timber.tag("FirebaseMessaging token:").e(token)
        }


    }



}