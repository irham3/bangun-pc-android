package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.local.datasource.ProductLDS
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.data.source.remote.dataresource.ProductRDS
import com.kaizen.bangunpc.data.source.remote.result.ComponentResult
import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import com.kaizen.bangunpc.data.source.remote.result.PCBuildResult
import com.kaizen.bangunpc.ui.common.UiState
import com.kaizen.bangunpc.utils.AppExecutors
import com.kaizen.bangunpc.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val productRDS: ProductRDS,
    private val productLDS: ProductLDS,
    private val appExecutors: AppExecutors
) : IProductRepository {
    override fun getAllProducts(): Flow<List<ProductEntity>> =
        productLDS.getAllProducts()

    override fun getProductById(productId: Int): Flow<ProductEntity> =
        productLDS.getProductById(productId)

    override fun getAllComponents() : Flow<List<ProductEntity>> =
        productLDS.getAllComponents()

    override fun getAllPCBuilds(): Flow<List<ProductEntity>> =
        productLDS.getAllPCBuilds()

    override fun getWishlist(): Flow<List<ProductEntity>> =
        productLDS.getWishlist()

    override fun getAllIntelPCs(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<PCBuildResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllIntelPCs()

            override suspend fun createCall(): Flow<ApiResult<List<PCBuildResult>>> =
                productRDS.getAllIntelPCs()

            override suspend fun saveCallResult(data: List<PCBuildResult>) {
                val componentList = DataMapper.mapPCBuildResultToProductEntity(data, "intel")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllAMDPCs(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<PCBuildResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllAMDPCs()

            override suspend fun createCall(): Flow<ApiResult<List<PCBuildResult>>> =
                productRDS.getAllAMDPCs()

            override suspend fun saveCallResult(data: List<PCBuildResult>) {
                val componentList = DataMapper.mapPCBuildResultToProductEntity(data, "amd")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllCPUs(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllCPUs()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                productRDS.getAllCPUs()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "cpu")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllGPUs(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllGPUs()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                productRDS.getAllGPUs()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "gpu")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllCasings(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllCasings()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                productRDS.getAllCasings()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "casing")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllMemories(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllMemories()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                productRDS.getAllMemories()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "memory")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllMotherboards(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllMotherboards()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                productRDS.getAllMotherboards()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "motherboard")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllPSUs(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllPSUs()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                productRDS.getAllPSUs()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "psu")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllStorages(): Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAllStorages()
            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                productRDS.getAllStorages()
            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "storage")
                productLDS.insert(componentList)
            }
            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun setFavorite(productEntity: ProductEntity, status: Boolean) {
        appExecutors.diskIO().execute {
            productLDS.setFavorite(productEntity, status)
        }
    }
}