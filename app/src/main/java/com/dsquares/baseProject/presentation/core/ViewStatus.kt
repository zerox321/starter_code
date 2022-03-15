package com.dsquares.baseProject.presentation.core

sealed class ViewStatus<out T : Any> {
    data class Success<out T : Any>(val data: T) : ViewStatus<T>()
    data class Error(val throwable: Throwable, val errorBody: String?) : ViewStatus<Nothing>()
    object Loading : ViewStatus<Nothing>()
}