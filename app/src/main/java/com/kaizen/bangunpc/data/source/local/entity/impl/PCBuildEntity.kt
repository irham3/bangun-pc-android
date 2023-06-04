package com.kaizen.bangunpc.data.source.local.entity.impl

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kaizen.bangunpc.data.source.local.entity.IProductEntity

@Entity(tableName = "pcbuild")
data class PCBuildEntity(
    @PrimaryKey
    @ColumnInfo(name = "componentId")
    override var id: Int,

    @ColumnInfo(name = "name")
    override var name: String,

    @ColumnInfo(name = "price")
    override var price: Int,

    @ColumnInfo(name = "description")
    override var description: String,

    @ColumnInfo(name = "image")
    override var image: String,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "category")
    var category: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : IProductEntity
