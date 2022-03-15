package com.dsquares.baseProject.util

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import retrofit2.HttpException
import timber.log.Timber

object ExceptionHandling {
    private const val tag = "ExceptionHandling"

    fun Throwable.getErrorBody(): String? {
        Timber.tag(tag).e(this)
        Firebase.crashlytics.recordException(this)

        return if (this is HttpException) response()?.errorBody()?.string() else null
    }

    fun safeTaskHandler(task: () -> Unit) = try {
        task.invoke()
    } catch (t: Throwable) {
        Timber.tag(tag).e("$t")
        Firebase.crashlytics.recordException(t)
    }
}