package com.dsquares.baseProject.presentation.core

import com.dsquares.baseProject.presentation.ui.ui.home.HomeViewStatus
import com.dsquares.baseProject.util.ExceptionHandling.getErrorBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext

abstract class BaseRepository {

    protected val defaultDispatcher = Dispatchers.IO



    protected suspend fun buildRoom(task: suspend () -> Any?) = withContext(defaultDispatcher) {
        task()
    }


}