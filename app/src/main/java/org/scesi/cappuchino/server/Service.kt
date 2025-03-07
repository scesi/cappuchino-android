package org.scesi.cappuchino.server


import org.scesi.cappuchino.server.models.SearchCategory
import retrofit2.http.GET

interface Service {
    @GET("FCyT/index.json")
    suspend fun getCareers(): List<SearchCategory.RemoteCareer>
}