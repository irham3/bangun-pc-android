package com.kaizen.bangunpc.data.source.remote.result

import kotlinx.serialization.Serializable

@Serializable
data class ComponentResult(
    val id: Int,
    val name: String,
    val price: Int,
    val url: String,
    val image: String,
    val description: String
)