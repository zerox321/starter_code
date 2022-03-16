package com.dsquares.baseProject.presentation.ui.ui.home

import com.dsquares.baseProject.presentation.core.BaseViewModel
import com.dsquares.baseProject.util.ExceptionHandling.getErrorBody
import dagger.hilt.android.lifecycle.HiltViewModel
import dsquares.com.core.entities.remote.MenuItem
import dsquares.com.core.usecase.GetAllMenus
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val menuUseCase: GetAllMenus) :
    BaseViewModel() {
    private val _response = MutableStateFlow<HomeViewStatus<List<MenuItem>>>(HomeViewStatus.Loading)
    val menuListResponse get() = _response
    fun getMenuList() = launchTask {
        _response.emitAll(flow = flow {
            val response = menuUseCase.invoke()
            if (response.isNullOrEmpty()) {
                emit(HomeViewStatus.EMPTY)
                return@flow
            }
            emit(HomeViewStatus.Success(data = response))
        }
            .flowOn(defaultDispatcher)
            .onStart { emit(HomeViewStatus.Loading) }
            .catch { throwable -> emit(
                    HomeViewStatus.Error(
                        throwable = throwable,
                        errorBody = throwable.getErrorBody()
                    )
                )
            })


    }

    init {
        getMenuList()
    }
}