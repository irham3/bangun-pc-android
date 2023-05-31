package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.local.LocalDataSource
import com.kaizen.bangunpc.data.source.local.entity.ComponentEntity
import com.kaizen.bangunpc.data.source.remote.RemoteDataSource
import com.kaizen.bangunpc.data.source.remote.result.ComponentResult
import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import com.kaizen.bangunpc.utils.AppExecutors
import com.kaizen.bangunpc.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComponentRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IComponentRepository {
    override fun getAllComponents() : Flow<UiState<List<ComponentEntity>>> =
        object : NetworkBoundResource<List<ComponentEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ComponentEntity>> =
                localDataSource.getAllComponents()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                remoteDataSource.getAllComponents()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapResultToEntities(data)
                localDataSource.insertComponent(componentList)
            }

            override fun shouldFetch(data: List<ComponentEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllFavoriteComponents(): Flow<List<ComponentEntity>> =
        localDataSource.getAllFavoriteComponents()

    override fun setFavoriteComponent(componentEntity: ComponentEntity, status: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteComponent(componentEntity, status)
        }
    }
}