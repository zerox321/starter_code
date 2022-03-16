package com.dsquares.baseProject.datasource.remote.service

import com.dsquares.baseProject.datasource.EndPoint.urlConstant
import retrofit2.http.GET


interface ApiService {
    @GET(value = urlConstant)
    suspend fun getMenu(): List<dsquares.com.core.entities.remote.MenuItem>
}