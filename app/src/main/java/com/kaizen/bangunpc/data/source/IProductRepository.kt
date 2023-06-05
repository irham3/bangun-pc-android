package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface IProductRepository {
    fun getAllProducts() : Flow<UiState<List<ProductEntity>>>
    fun getAllFavorites() : Flow<List<ProductEntity>>
    fun getAllComponents() : Flow<UiState<List<ProductEntity>>>
    fun getAllPCBuilds() : Flow<UiState<List<ProductEntity>>>
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