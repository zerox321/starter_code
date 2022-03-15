package com.dsquares.baseProject.data.datasource.remote.service

import com.dsquares.baseProject.data.EndPoint.urlConstant
import com.dsquares.baseProject.data.entities.remote.MenuItem
import retrofit2.http.GET


interface ApiService {
    @GET(value = urlConstant)
    suspend fun getMenu(): List<MenuItem>
}