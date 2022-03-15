package com.dsquares.baseProject.presentation.ui.ui.home

sealed class HomeViewStatus<out T : Any> {
    data class Success<out T : Any>(val data: T) : HomeViewStatus<T>()
    data class Error(val throwable: Throwable, val errorBody: String?) : HomeViewStatus<Nothing>()
    object Loading : HomeViewStatus<Nothing>()
    object EMPTY : HomeViewStatus<Nothing>()
}