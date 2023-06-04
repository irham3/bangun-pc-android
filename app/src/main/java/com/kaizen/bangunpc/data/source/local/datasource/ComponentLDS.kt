package com.kaizen.bangunpc.data.source.local.datasource

import com.kaizen.bangunpc.data.source.local.entity.impl.ComponentEntity
import com.kaizen.bangunpc.data.source.local.room.ProductDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComponentLDS @Inject constructor(
    private val productDao: ProductDao
) {
    suspend fun insert(componentList: List<ComponentEntity>) =
        productDao.insert(componentList)

    fun getAll() : Flow<List<ComponentEntity>> =
        productDao.getAll()

    fun getAllFavorites() : Flow<List<ComponentEntity>> =
        productDao.getAllFavorites()

    fun setFavorite(componentEntity: ComponentEntity, newStatus: Boolean) {
        componentEntity.isFavorite = newStatus
        productDao.update(componentEntity)
    }
}