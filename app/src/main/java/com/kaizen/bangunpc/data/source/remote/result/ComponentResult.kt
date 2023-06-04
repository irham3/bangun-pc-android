package com.kaizen.bangunpc.data.source.remote.result

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class ComponentResult(
    val gxcomp: @Contextual Gxcomp
)

@Serializable
data class Gxcomp(
    val image: String,
    val price: Int,
    val name: String,
    val description: String,
    val id: Int,
    val url: String
)

