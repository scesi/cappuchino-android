package org.scesi.cappuchino.data.server

import android.util.Log
import org.koin.core.annotation.Factory
import org.scesi.cappuchino.data.server.models.CareerResponse
import org.scesi.data.dataSources.CareerRemoteDataSource
import org.scesi.domain.models.SearchCategory

@Factory
class CareerApiDataSource: CareerRemoteDataSource {
    override suspend fun getCareer() = tryCall {
        val careers = RemoteConnection.service.getCareers()
        careers.map { it.toDomainModel() }
    }
}

private fun CareerResponse.toDomainModel(): SearchCategory.Career =
    SearchCategory.Career(name = this.name)
