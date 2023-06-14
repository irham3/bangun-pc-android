package com.kaizen.bangunpc.utils

import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.data.source.remote.dto.ComponentDto
import com.kaizen.bangunpc.data.source.remote.dto.PCBuildDto

object DataMapper {

    fun mapComponentDtoToProductEntity(input: List<ComponentDto>, category: String): List<ProductEntity> {
        val productList = ArrayList<ProductEntity>()
        input.map {
            val product = ProductEntity(
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

    fun mapPCBuildDtoToProductEntity(input: List<PCBuildDto>, category: String): List<ProductEntity> {
        val productList = ArrayList<ProductEntity>()
        input.map {
            val product = ProductEntity(
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