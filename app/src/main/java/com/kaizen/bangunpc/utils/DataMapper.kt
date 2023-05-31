package com.kaizen.bangunpc.utils

import com.kaizen.bangunpc.data.source.local.entity.ComponentEntity
import com.kaizen.bangunpc.data.source.remote.result.ComponentResult

object DataMapper {
    fun mapResultToEntities(input: List<ComponentResult>): List<ComponentEntity> {
        val componentList = ArrayList<ComponentEntity>()
        input.map {
            val component = ComponentEntity(
                componentId = it.id,
                name = it.name,
                price = it.price,
                url = it.url,
                description = it.description,
                image = it.image,
                isFavorite = false
            )
            componentList.add(component)
        }
        return componentList
    }
}