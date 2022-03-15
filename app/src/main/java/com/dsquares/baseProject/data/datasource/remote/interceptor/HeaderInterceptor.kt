package com.dsquares.baseProject.data.datasource.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
) : Interceptor {

//    private val language: String get() = pref.getLanguage()
//    private val token: String? get() = pref.getToken()


    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request.Builder = chain.request().newBuilder().apply {
            addHeader("Accept", "application/json")
            addHeader("Content-Type", "application/json")
            addHeader("api-secret", "test")
//            addHeader("lang", language)
//             add token to header if token != null
//            token?.let { addHeader("Authorization", "Bearer $it") }

        }
        return chain.proceed(request.build())
    }
}