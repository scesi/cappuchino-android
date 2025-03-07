package org.scesi.cappuchino.server

suspend fun <T> tryCall(action: suspend () -> T): T {
    return try {
        action()
    } catch (e: Exception) {
        throw RuntimeException("Error en la llamada de red: ${e.message}", e)
    }
}