package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.local.datasource.ProductLDS
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.data.source.remote.RemoteDataSource
import com.kaizen.bangunpc.data.source.remote.result.ComponentResult
import com.kaizen.bangunpc.data.source.remote.network.ApiResult
import com.kaizen.bangunpc.utils.AppExecutors
import com.kaizen.bangunpc.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val productLDS: ProductLDS,
    private val appExecutors: AppExecutors
) : IProductRepository {
    override fun getAllComponents() : Flow<UiState<List<ProductEntity>>> =
        flow {
            productLDS.getAll()
        }

    override fun getAllPCBuilds(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllIntelPCs(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllAMDPCs(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllCPUs(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllGPUs(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllCasings(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllMemories(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllMotherboards(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllPSUs(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllStorages(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    fun getAllCpus() : Flow<UiState<List<ProductEntity>>> =
        object : NetworkBoundResource<List<ProductEntity>, List<ComponentResult>>() {
            override fun loadFromDB(): Flow<List<ProductEntity>> =
                productLDS.getAll()

            override suspend fun createCall(): Flow<ApiResult<List<ComponentResult>>> =
                remoteDataSource.getAllCpus()

            override suspend fun saveCallResult(data: List<ComponentResult>) {
                val componentList = DataMapper.mapComponentResultToProductEntity(data, "cpu")
                productLDS.insert(componentList)
            }

            override fun shouldFetch(data: List<ProductEntity>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getAllProducts(): Flow<UiState<List<ProductEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getAllFavorites(): Flow<List<ProductEntity>> =
        productLDS.getAllFavorites()

    override fun setFavorite(productEntity: ProductEntity, status: Boolean) {
        appExecutors.diskIO().execute {
            productLDS.setFavorite(productEntity, status)
        }
    }
}