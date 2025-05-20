package org.scesi.cappuchino.data.server


import org.scesi.cappuchino.data.server.models.CareerResponse
import org.scesi.cappuchino.data.server.models.SubjectResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("FCyT/index.json")
    suspend fun getCareers(): List<CareerResponse>

    @GET("FCyT/{careerPath}/{subjectCode}.json")
    suspend fun getSubjects(
        @Path("careerPath") careerPath: String,
        @Path("subjectCode") subjectCode: String
    ): SubjectResponse
}