package com.dsquares.baseProject.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.dsquares.baseProject.util.ExceptionHandling.safeTaskHandler

object ActivityLauncher {

    fun Context.launchEmptySessions() = safeTaskHandler {
//        startActivity(Intent(this, ExpiredSessionActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        })
    }

}