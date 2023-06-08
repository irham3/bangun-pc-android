package com.kaizen.bangunpc.ui.screen.detail

import com.kaizen.bangunpc.data.source.local.entity.ProductEntity

interface DetailUiState {
    val error: String

    data class Product(
        val data: ProductEntity = ProductEntity(),
        override val error: String = "Undefined error"
    ) : DetailUiState

    data class isFavorite(
        val data: Boolean = false,
        override val error: String = "Undefined error"
    ) : DetailUiState

}