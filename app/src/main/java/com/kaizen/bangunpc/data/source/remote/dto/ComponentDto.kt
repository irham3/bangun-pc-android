package com.kaizen.bangunpc.data.source.remote.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class ComponentDto(
    val gxcomp: @Contextual Gxcomp
)

@Serializable
data class Gxcomp(
    val image: String,
    val price: Int,
    val name: String,
    val quantity: Int,
    val description: String,
    val id: Int,
    val url: String
)

