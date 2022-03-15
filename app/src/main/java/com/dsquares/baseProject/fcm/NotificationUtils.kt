package com.dsquares.baseProject.fcm


import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.dsquares.baseProject.R
import com.dsquares.baseProject.fcm.NotificationParser.getParsingString
import com.dsquares.baseProject.fcm.NotificationParser.orderIDParser
import com.dsquares.baseProject.fcm.NotificationParser.storeIdParser
import com.dsquares.baseProject.fcm.NotificationParser.typeParser
//import com.dsquares.baseProject.presentation.ui.home.HomeActivity

import org.json.JSONObject
import timber.log.Timber
import java.util.*

object NotificationUtils {


    private val VIBRATE_PATTERN = longArrayOf(0, 500)


    fun NotificationManager.sendNotification(
        title: String,
        messageBody: String,
        intent: Intent,
        applicationContext: Context
    ) {

        val contentPendingIntent = PendingIntent.getActivity(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )


        val builder = NotificationCompat.Builder(
            applicationContext, applicationContext.getString(R.string.notification_channel_id)
        ).apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle(title)
            setContentText(messageBody)
            setStyle(NotificationCompat.BigTextStyle().bigText(messageBody))
            setContentIntent(contentPendingIntent)
            priority = NotificationCompat.PRIORITY_MAX
            setAutoCancel(true)
            setVibrate(VIBRATE_PATTERN)
        }

        notify(Random().nextInt(), builder.build())

    }

//    fun Context.buildIntent(data: JSONObject): Intent =
//        Intent(this, HomeActivity::class.java).apply {
//            Timber.e("buildIntent: %s", data)
//
//            putExtra(typeParser, data.getParsingString(typeParser))
//            putExtra(orderIDParser, data.getParsingString(orderIDParser))
//            putExtra(storeIdParser, data.getParsingString(storeIdParser))
//            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
//        }

}


