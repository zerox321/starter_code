package com.dsquares.baseProject.presentation.core

import com.dsquares.baseProject.util.ExceptionHandling.getErrorBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext

abstract class BaseRepository {

    private val defaultDispatcher = Dispatchers.IO
    protected suspend fun <T : Any> buildApi(task: suspend () -> T) =
        flow<ViewStatus<T>> {
            emit(ViewStatus.Success(data = task()))
        }
            .flowOn(defaultDispatcher)
            .onStart { emit(ViewStatus.Loading) }
            .catch { throwable ->
                emit(ViewStatus.Error(throwable = throwable, errorBody = throwable.getErrorBody()))
            }

//    protected suspend inline fun <reified T : Any?> Socket.buildSocket(
//        event: String
//    ) = flow<ViewStatus<T>> {
//            this@buildSocket.on(event) { args ->
//                CoroutineScope(defaultDispatcher).launch {
//               val response=Json.decodeFromString<T>(args[0].toString())
//                        emit(ViewStatus.Success(data = response))
//                }
//            }
//        }
//            .flowOn(defaultDispatcher)
//            .catch { throwable ->
//                emit(ViewStatus.Error(throwable = throwable, errorBody = getErrorBody(throwable)))
//            }


    protected suspend fun buildRoom(task: suspend () -> Any?) = withContext(defaultDispatcher) {
        task()
    }

//    @ExperimentalSerializationApi
//    protected  inline fun <reified T:BaseResponse<Any?>> Socket.emitData(eventName: String, data: String) {
//        if (!connected()) connect()
//        Timber.tag("emitData").e("eventName : $eventName data : $data ")
//
//        this@emitData.emit(eventName, data, Ack {
//            CoroutineScope(defaultDispatcher).launch {
//                val response=Json.decodeFromString<T>(it[0].toString())
//                ViewStatus.Success(data = response)
//            }
//        })
//
//    }
    /**
     * Generates a custom Moshi Adapter for the given [type] retrieved from the reified type parameter.
     */
//    fun <T : BaseResponse<Any?>> getAdapterOfType(
//        type: KClass<T>,
//        moshi: Moshi
//    ): JsonAdapter<BaseResponse<T>> {
//        val typeA: Type = Types.newParameterizedType(
//            BaseResponse::class.java,
//            type::class.java
//        )
//        return moshi.adapter(typeA)
//    }

}