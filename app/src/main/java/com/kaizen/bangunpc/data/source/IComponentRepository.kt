package com.kaizen.bangunpc.data.source

import com.kaizen.bangunpc.data.source.local.entity.impl.ComponentEntity
import kotlinx.coroutines.flow.Flow

interface IComponentRepository {
    fun getAllComponents() : Flow<UiState<List<ComponentEntity>>>
    fun getAllFavoriteComponents() : Flow<List<ComponentEntity>>
    fun setFavoriteComponent(componentEntity: ComponentEntity, status: Boolean)
}