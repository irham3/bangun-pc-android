package com.kaizen.bangunpc.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "productId")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "price")
    var price: Int,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "isPCBuild")
    var isPCBuild: Boolean = false,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

)