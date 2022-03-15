package com.dsquares.baseProject.fcm

import android.content.Intent
import org.json.JSONException
import org.json.JSONObject

object NotificationParser {

    const val typeParser = "type"
    const val storeIdParser = "storeId"
    const val orderIDParser = "orderID"

    fun Intent.getIntentExtraString(Key: String): String = if (getStringExtra(Key) == null)
        extras?.get(Key).toString()
    else
        getStringExtra(Key) ?: ""


    fun JSONObject.getParsingString(Key: String): String = try {
        getString(Key)
    } catch (e: JSONException) {
        ""
    }

    fun String.safeToInt(): Int =
        try {
            toInt()
        } catch (ex: NumberFormatException) { // handle your exception
            0
        }


}
