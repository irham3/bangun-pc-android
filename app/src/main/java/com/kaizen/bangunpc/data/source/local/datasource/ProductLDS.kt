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

    fun getAllProducts() : Flow<List<ProductEntity>> =
        productDao.getAllProducts()

    fun getProductsName(name: String) : Flow<List<ProductEntity>> =
        productDao.getProductsByName(name)

    fun getProductById(productId: Int) : Flow<ProductEntity> =
        productDao.getProductById(productId)

    fun getWishlist() : Flow<List<ProductEntity>> =
        productDao.getWishlist()

    fun getAllComponents() : Flow<List<ProductEntity>> =
        productDao.getAllComponents()

    fun getAllPCBuilds() : Flow<List<ProductEntity>> =
        productDao.getAllPCBuilds()

    fun getAllIntelPCs() : Flow<List<ProductEntity>> =
        productDao.getAllIntelPCs()

    fun getAllAMDPCs() : Flow<List<ProductEntity>> =
        productDao.getAllAMDPCs()

    fun getAllCPUs() : Flow<List<ProductEntity>> =
        productDao.getAllCPUs()

    fun getAllGPUs() : Flow<List<ProductEntity>> =
        productDao.getAllGPUs()

    fun getAllCasings() : Flow<List<ProductEntity>> =
        productDao.getAllCasings()

    fun getAllMemories() : Flow<List<ProductEntity>> =
        productDao.getAllMemories()

    fun getAllMotherboards() : Flow<List<ProductEntity>> =
        productDao.getAllMotherboards()

    fun getAllPSUs() : Flow<List<ProductEntity>> =
        productDao.getAllPSUs()

    fun getAllStorages() : Flow<List<ProductEntity>> =
        productDao.getAllStorages()

    fun setFavorite(componentEntity: ProductEntity, newStatus: Boolean) {
        componentEntity.isFavorite = newStatus
        productDao.update(componentEntity)
    }
}