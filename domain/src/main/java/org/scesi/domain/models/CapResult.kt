package org.scesi.domain.models

sealed class CapResult<out S, out E> {
    data class Success<out S>(val data: S) : CapResult<S, Nothing>()
    data class Error<out E>(val error:E) : CapResult<Nothing, E>()
}