package com.kaizen.bangunpc.ui.common

sealed class MessageState<out T: Any?> {

    object Loading : MessageState<Nothing>()

    data class Success(val successMessage: String) : MessageState<Nothing>()
    data class Warning(val warningMessage: String) : MessageState<Nothing>()
    data class Error(val errorMessage: String) : MessageState<Nothing>()
}