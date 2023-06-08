package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import com.kaizen.bangunpc.ui.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType : Any, RequestType> {

    private var result: Flow<UiState<ResultType>> = flow {
        emit(UiState.Loading)
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(UiState.Loading)
            when (val apiResult = createCall().first()) {
                is ApiResult.Success -> {
                    saveCallResult(apiResult.data)
                    emitAll(loadFromDB().map { UiState.Success(it) })
                }
                is ApiResult.Loading -> {
                    emitAll(loadFromDB().map { UiState.Success(it) })
                }
                is ApiResult.Error -> {
                    onFetchFailed()
                    emit(UiState.Error(apiResult.errorMessage))
                }
            }
        } else {
            emitAll(loadFromDB().map { UiState.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResult<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<UiState<ResultType>> = result
}