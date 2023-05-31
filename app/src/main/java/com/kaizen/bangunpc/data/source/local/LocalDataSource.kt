package com.kaizen.bangunpc.data.source.local

import com.kaizen.bangunpc.data.source.local.entity.ComponentEntity
import com.kaizen.bangunpc.data.source.local.room.ComponentDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val componentDao: ComponentDao
) {
    suspend fun insertComponent(componentList: List<ComponentEntity>) =
        componentDao.insertComponent(componentList)

    fun getAllComponents() : Flow<List<ComponentEntity>> =
        componentDao.getAllComponents()

    fun getAllFavoriteComponents() : Flow<List<ComponentEntity>> =
        componentDao.getFavoriteComponents()

    fun setFavoriteComponent(componentEntity: ComponentEntity, newStatus: Boolean) {
        componentEntity.isFavorite = newStatus
        componentDao.updateFavoriteComponent(componentEntity)
    }
}