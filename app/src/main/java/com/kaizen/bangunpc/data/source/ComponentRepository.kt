package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.local.datasource.ComponentLDS
import com.kaizen.bangunpc.data.source.local.entity.impl.ComponentEntity
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
    private val componentLDS: ComponentLDS,
    private val appExecutors: AppExecutors
) : IComponentRepository {
    override fun getAllComponents() : Flow<UiState<List<ComponentEntity>>> =
        object : NetworkBoundResource<List<ComponentEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ComponentEntity>> =
                componentLDS.getAll()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                remoteDataSource.getAllComponents()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapResultToEntities(data)
                componentLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ComponentEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()
    
    fun getAllCpus() : Flow<UiState<List<ComponentEntity>>> =
        object : NetworkBoundResource<List<ComponentEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ComponentEntity>> =
                componentLDS.getAll()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                remoteDataSource.getAllCpus()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapResultToEntities(data)
                componentLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ComponentEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllFavoriteComponents(): Flow<List<ComponentEntity>> =
        componentLDS.getAllFavorites()

    override fun setFavoriteComponent(componentEntity: ComponentEntity, status: Boolean) {
        appExecutors.diskIO().execute {
            componentLDS.setFavorite(componentEntity, status)
        }
    }
}