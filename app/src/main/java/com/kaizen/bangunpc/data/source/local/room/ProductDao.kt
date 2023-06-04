package com.kaizen.bangunpc.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kaizen.bangunpc.data.source.local.entity.impl.ComponentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0")
    fun getAllComponents() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM component WHERE isFavorite = 1")
    fun getAllFavorites() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"cpu\"")
    fun getAllCPUs() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"gpu\"")
    fun getAllGPUs() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"casing\"")
    fun getAllCasings() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"memory\"")
    fun getAllMemories() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"motherboard\"")
    fun getAllMotherboards() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"psu\"")
    fun getAllPSUs() : Flow<List<ComponentEntity>>

    @Query("SELECT * FROM product WHERE isPCBuild = 0 AND category = \"storage\"")
    fun getAllStorages() : Flow<List<ComponentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(componentEntity: List<ComponentEntity>)

    @Update
    fun update(componentEntity: ComponentEntity)
}