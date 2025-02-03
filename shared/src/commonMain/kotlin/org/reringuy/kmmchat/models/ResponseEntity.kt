package org.reringuy.kmmchat.models

sealed class ResponseEntity<out T> {
    data object Loading: ResponseEntity<Nothing>()

    data class Success<out T>(val data: T): ResponseEntity<T>()

    data class Error(val error: String): ResponseEntity<Nothing>()
}