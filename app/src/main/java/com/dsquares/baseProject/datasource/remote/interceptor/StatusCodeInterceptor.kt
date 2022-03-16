package com.dsquares.baseProject.datasource.remote.interceptor

import android.content.Context
import com.dsquares.baseProject.presentation.util.ActivityLauncher.launchEmptySessions
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class StatusCodeInterceptor @Inject constructor(
    private val context: Context,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val response: Response = chain.proceed(originalRequest)
        // remove user data if code is unAuthenticated (401)
        if (response.code == 401) removeUser()
        return response
    }

    private fun removeUser() {
        // remove user data from pref
//        pref.removeUser()
        // open Expired Session View
        context.launchEmptySessions()
    }
}