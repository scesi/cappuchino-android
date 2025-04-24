package org.scesi.cappuchino.data

import org.scesi.cappuchino.network.toError
import org.scesi.domain.models.CapResult

inline fun <T> tryCall(action: () -> T) = try {
    CapResult.Success(action())
}catch (e: java.lang.Exception){
    e.message?.let {  }
    CapResult.Error(e.toError())
}