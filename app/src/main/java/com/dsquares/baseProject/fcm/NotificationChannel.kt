package com.dsquares.baseProject.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build

object NotificationChannel {

    fun NotificationManager.buildNotificationChannel(channelId: String, channelName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                setShowBadge(true)
                lightColor = Color.RED
                enableVibration(true)
                description = channelName
            })
        }
    }
}
