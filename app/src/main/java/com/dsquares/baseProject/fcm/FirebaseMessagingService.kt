package com.dsquares.baseProject.fcm

import android.app.NotificationManager
import android.content.Intent
import com.dsquares.baseProject.fcm.NotificationUtils.buildIntent
import com.dsquares.baseProject.fcm.NotificationUtils.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class FirebaseMessagingService : FirebaseMessagingService() {

    private val tag = javaClass.simpleName

    @Inject
    lateinit var notificationManager: NotificationManager


    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        if (remoteMessage.data.isNullOrEmpty() || remoteMessage.notification == null) return

        val data = JSONObject(remoteMessage.data as Map<*, *>)

        val intent = buildIntent(data = data)
        val title = remoteMessage.notification?.title ?: "" //get title
        val message = remoteMessage.notification?.body ?: "" //get message
        val clickAction = remoteMessage.notification?.clickAction //get click_action
        Timber.tag(tag).e(" Title: %s", title)
        Timber.tag(tag).e(" Body: %s", message)
        Timber.tag(tag).e("Message Notification click_action: %s", clickAction)

        sendNotification(title, message, intent)
    }


    override fun onNewToken(Token: String) {
        super.onNewToken(Token)
        updateTokenApi(Token)
    }

    private fun updateTokenApi(Token: String) {
        Timber.tag(tag).e("updateTokenApi Token: %s", Token)
    }


    private fun sendNotification(
        title: String,
        messageBody: String,
        intent: Intent
    ) {
        notificationManager.sendNotification(
            title = title,
            messageBody = messageBody,
            intent = intent,
            applicationContext = this
        )
    }


}
