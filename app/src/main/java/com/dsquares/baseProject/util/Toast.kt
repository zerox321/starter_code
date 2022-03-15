package com.dsquares.baseProject.util

import android.content.Context
import android.widget.Toast


object Toast {
    fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}