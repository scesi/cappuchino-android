package org.scesi.cappuchino.network


import retrofit2.HttpException
import org.scesi.domain.models.CapError
import java.io.IOException

fun Throwable.toError(): CapError = when (this) {
    is IOException -> CapError.Connectivity
    is HttpException -> CapError.Server(code())
    else -> CapError.Unknown(message ?: "")
}