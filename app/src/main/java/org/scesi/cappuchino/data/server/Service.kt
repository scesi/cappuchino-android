package org.scesi.cappuchino.data.server


import org.scesi.cappuchino.data.server.models.CareerResponse
import retrofit2.http.GET

interface Service {
    @GET("FCyT/index.json")
    suspend fun getCareers(): List<CareerResponse>
}