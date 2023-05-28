package com.kaizen.bangunpc.data

import kotlinx.serialization.Serializable

@Serializable
data class Component(
    val id: Int,
    val price: Int,
    val url: String,
    val name: String,
    val image: String,
    val description: String
)