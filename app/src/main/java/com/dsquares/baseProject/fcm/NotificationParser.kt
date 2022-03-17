package com.dsquares.baseProject.fcm

import android.content.Intent
import org.json.JSONException
import org.json.JSONObject

object NotificationParser {

    const val typeParser = "type"

    fun Intent.getIntentExtraString(Key: String): String = if (getStringExtra(Key) == null)
        extras?.get(Key).toString()
    else
        getStringExtra(Key) ?: ""


    fun JSONObject.getParsingString(Key: String): String = try {
        getString(Key)
    } catch (e: JSONException) {
        ""
    }



}
