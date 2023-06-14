package com.kaizen.bangunpc.data.source.repository

import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.ui.common.UiState
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts() : Flow<List<ProductEntity>>
    fun getProductsByName(query: String) : Flow<List<ProductEntity>>
    fun getProductById(productId: Int) : Flow<ProductEntity>
    fun getWishlist() : Flow<List<ProductEntity>>
    fun getAllComponents() : Flow<List<ProductEntity>>
    fun getAllPCBuilds() : Flow<List<ProductEntity>>
    fun getAllIntelPCs() : Flow<UiState<List<ProductEntity>>>
    fun getAllAMDPCs() : Flow<UiState<List<ProductEntity>>>
    fun getAllCPUs() : Flow<UiState<List<ProductEntity>>>
    fun getAllGPUs() : Flow<UiState<List<ProductEntity>>>
    fun getAllCasings() : Flow<UiState<List<ProductEntity>>>
    fun getAllMemories() : Flow<UiState<List<ProductEntity>>>
    fun getAllMotherboards() : Flow<UiState<List<ProductEntity>>>
    fun getAllPSUs() : Flow<UiState<List<ProductEntity>>>
    fun getAllStorages() : Flow<UiState<List<ProductEntity>>>
    fun setFavorite(productEntity: ProductEntity, status: Boolean)
}