package com.kaizen.bangunpc.data.source.remote.result

import kotlinx.serialization.Serializable

@Serializable
data class PCBuildResult(
    val id: Int,
    val price: Int,
    val url: String,
    val name: String,
    val image: String,
    val description: String,
    val category: Int,
)