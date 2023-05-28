package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(Resource.Loading())
            when (val apiResult = createCall().first()) {
                is ApiResult.Success -> {
                    saveCallResult(apiResult.data)
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResult.Empty -> {
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResult.Error -> {
                    onFetchFailed()
                    emit(Resource.Error(apiResult.errorMessage))
                }
            }
        } else {
            emitAll(loadFromDB().map { Resource.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResult<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result
}