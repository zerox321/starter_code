package com.dsquares.baseProject.data.repository

import com.dsquares.baseProject.data.datasource.remote.service.ApiService
import com.dsquares.baseProject.data.entities.remote.MenuItem
import com.dsquares.baseProject.presentation.core.BaseRepository
import com.dsquares.baseProject.presentation.ui.ui.home.HomeViewStatus
import com.dsquares.baseProject.util.ExceptionHandling.getErrorBody
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ViewModelScoped
class MenuRepo @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    val _response = MutableStateFlow<HomeViewStatus<List<MenuItem>>>(HomeViewStatus.Loading)
    suspend fun fetchMenuList() = _response.emitAll(flow = flow {
        val response = apiService.getMenu()
        if (response.isNullOrEmpty()) {
            emit(HomeViewStatus.EMPTY)
            return@flow
        }
        emit(HomeViewStatus.Success(data = response))
    }
        .flowOn(defaultDispatcher)
        .onStart {

            emit(HomeViewStatus.Loading)
        }
        .catch { throwable ->
            emit(
                HomeViewStatus.Error(
                    throwable = throwable,
                    errorBody = throwable.getErrorBody()
                )
            )
        })


}