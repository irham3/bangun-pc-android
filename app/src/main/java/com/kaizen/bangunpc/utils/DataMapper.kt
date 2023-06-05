package com.kaizen.bangunpc.utils

import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.data.source.remote.result.ComponentResult
import com.kaizen.bangunpc.data.source.remote.result.PCBuildResult

object DataMapper {

    fun mapComponentResultToProductEntity(input: List<ComponentResult>, category: String): List<ProductEntity> {
        val productList = ArrayList<ProductEntity>()
        input.map {
            val product = ProductEntity(
                id = it.gxcomp.id,
                name = it.gxcomp.name,
                price = it.gxcomp.price,
                url = it.gxcomp.url,
                description = it.gxcomp.description,
                image = it.gxcomp.image,
                isPCBuild = false,
                category = category,
                isFavorite = false
            )
            productList.add(product)
        }
        return productList
    }

    fun mapPCBuildResultToProductEntity(input: List<PCBuildResult>, category: String): List<ProductEntity> {
        val productList = ArrayList<ProductEntity>()
        input.map {
            val product = ProductEntity(
                id = it.id,
                name = it.name,
                price = it.price,
                url = it.url,
                description = it.description,
                image = it.image,
                isPCBuild = true,
                category = category,
                isFavorite = false
            )
            productList.add(product)
        }
        return productList
    }

}