package com.dsquares.baseProject.presentation.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

object KeyboardUtil {

    fun View.hideKeyboard() {
        val inputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager
        if (inputMethodManager?.isActive == true)
            inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }

}