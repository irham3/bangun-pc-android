package com.kaizen.bangunpc.data.source.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PCBuildDto(
    val id: Int,
    val price: Int,
    val url: String,
    val name: String,
    val image: String,
    val quantity: Int,
    val description: String,
    val category: Int,
)