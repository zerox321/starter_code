package com.dsquares.baseProject.presentation.ui.ui.home

import com.dsquares.baseProject.data.repository.MenuRepo
import com.dsquares.baseProject.presentation.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: MenuRepo) :
    BaseViewModel() {
    val menuListResponse = repo._response
    fun getMenuList() = launchTask { repo.fetchMenuList() }
    init { getMenuList() }
}