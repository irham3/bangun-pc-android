package com.kaizen.bangunpc.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kaizen.bangunpc.data.source.local.entity.impl.ComponentEntity
import com.kaizen.bangunpc.data.source.local.entity.impl.PCBuildEntity
import com.kaizen.bangunpc.data.source.local.entity.impl.ProductEntity
import com.kaizen.bangunpc.data.source.local.room.dao.PCBuildDao

@Database(entities = [
    ProductEntity::class
                     ], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao
}