package com.kaizen.bangunpc.data.source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val email: String,
    val fullname: String,
    @SerialName("avatar_url")
    val avatarUrl: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    val address: String? = null
)