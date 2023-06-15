package com.kaizen.bangunpc.data.source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int? = null,
    val email: String,
    val fullname: String,

    @SerialName("phone_number")
    val phoneNumber: String? = null,

    @SerialName("avatar_url")
    val avatarUrl: String? = null,

    val address: String? = null,

    val created_at: String? = null
)