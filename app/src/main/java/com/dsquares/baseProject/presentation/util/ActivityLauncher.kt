package com.dsquares.baseProject.presentation.util

import android.content.Context
import android.content.Intent
import com.dsquares.baseProject.presentation.ui.ExpiredSessionActivity
import com.dsquares.baseProject.presentation.ui.UpdatesActivity
import com.dsquares.baseProject.presentation.util.ExceptionHandling.safeTaskHandler

object ActivityLauncher {

    fun Context.launchEmptySessions() = safeTaskHandler {
        startActivity(Intent(this, ExpiredSessionActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        })
    }

    fun Context.launchUpdatesActivity() = safeTaskHandler {
        startActivity(Intent(this, UpdatesActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        })
    }

}