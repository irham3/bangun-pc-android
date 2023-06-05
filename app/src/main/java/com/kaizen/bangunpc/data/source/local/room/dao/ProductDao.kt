package com.kaizen.bangunpc.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAllProducts() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE productId = :productId")
    fun getProductById(productId: Int) : Flow<ProductEntity>

    @Query("SELECT * FROM product WHERE isFavorite = 1")
    fun getAllFavorites() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0")
    fun getAllComponents() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 1")
    fun getAllPCBuilds() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 1 AND category = \"intel\"")
    fun getAllIntelPCs() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 1 AND category = \"amd\"")
    fun getAllAMDPCs() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"cpu\"")
    fun getAllCPUs() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"gpu\"")
    fun getAllGPUs() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"casing\"")
    fun getAllCasings() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"memory\"")
    fun getAllMemories() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"motherboard\"")
    fun getAllMotherboards() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"psu\"")
    fun getAllPSUs() : Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"storage\"")
    fun getAllStorages() : Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: List<ProductEntity>)

    @Update
    fun update(productEntity: ProductEntity)
}