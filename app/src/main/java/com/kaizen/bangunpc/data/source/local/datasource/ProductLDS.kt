package com.kaizen.bangunpc.data.source.local.datasource

import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.data.source.local.room.dao.ProductDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductLDS @Inject constructor(
    private val productDao: ProductDao
) {
    suspend fun insert(componentList: List<ProductEntity>) =
        productDao.insert(componentList)

    fun getAll() : Flow<List<ProductEntity>> =
        productDao.getAllProducts()

    fun getAllFavorites() : Flow<List<ProductEntity>> =
        productDao.getAllFavorites()

    fun setFavorite(componentEntity: ProductEntity, newStatus: Boolean) {
        componentEntity.isFavorite = newStatus
        productDao.update(componentEntity)
    }
}