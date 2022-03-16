package com.dsquares.baseProject.datasource.repository

import com.dsquares.baseProject.datasource.remote.service.ApiService
import dsquares.com.core.entities.remote.MenuItem
import dsquares.com.core.repository.MenuRepo
import javax.inject.Inject

class MenuRepoImp @Inject constructor(private val apiService: ApiService) : MenuRepo {
    override suspend fun fetchMenuList(): List<MenuItem> = apiService.getMenu()
}