package org.scesi.domain.models

sealed class CapError {
    class Server(val code: Int, val message: String = "") : CapError()
    data object Connectivity : CapError()
    data object NotFound: CapError()
    class Unknown(val message: String) : CapError()
}