package org.scesi.cappuchino.data.server

suspend fun <T> tryCall(action: suspend () -> T): T {
    return try {
        action()
    } catch (e: Exception) {
        e.printStackTrace()
        throw RuntimeException("Error en la llamada de red: ${e.message}", e)
    }
}