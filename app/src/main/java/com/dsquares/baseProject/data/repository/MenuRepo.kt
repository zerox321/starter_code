package com.dsquares.baseProject.data.repository

import com.dsquares.baseProject.data.datasource.remote.service.ApiService
import com.dsquares.baseProject.data.entities.remote.MenuItem
import com.dsquares.baseProject.presentation.core.BaseRepository
import com.dsquares.baseProject.presentation.core.ViewStatus
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import javax.inject.Inject

@ViewModelScoped
class MenuRepo @Inject constructor(
    private val apiService: ApiService,
) : BaseRepository() {

    val response = MutableStateFlow<ViewStatus<List<MenuItem>>>(ViewStatus.Loading)
    suspend fun getMenuList() = response.emitAll(flow = buildApi { apiService.getMenu() })

}