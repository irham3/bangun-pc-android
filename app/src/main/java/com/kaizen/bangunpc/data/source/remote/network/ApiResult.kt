package com.kaizen.bangunpc.data.source.remote.network

sealed class ApiResult<out R> {
    data class Success<out R>(val data: R): ApiResult<R>()
    data class Error(val errorMessage: String): ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}