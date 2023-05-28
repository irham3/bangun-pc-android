package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.remote.RemoteDataSource
import com.kaizen.bangunpc.data.source.remote.result.Component
import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface IComponentRepository {
    fun getAllComponents() : Flow<Resource<List<Component>>>
}

@Singleton
class ComponentRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : IComponentRepository {
    override fun getAllComponents() : Flow<Resource<List<Component>>> =
        object : NetworkBoundResource<List<Component>, List<Component>>() {
            override fun loadFromDB(): Flow<List<Component>> {
                TODO("Not yet implemented")
            }

            override suspend fun createCall(): Flow<ApiResult<List<Component>>> =
                remoteDataSource.getAllComponents()

            override suspend fun saveCallResult(data: List<Component>) {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: List<Component>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()
}