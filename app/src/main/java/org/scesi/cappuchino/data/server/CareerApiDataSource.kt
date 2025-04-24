package org.scesi.cappuchino.data.server

import org.koin.core.annotation.Factory
import org.scesi.cappuchino.data.server.models.CareerResponse
import org.scesi.cappuchino.data.tryCall
import org.scesi.data.dataSources.CareerRemoteDataSource
import org.scesi.domain.models.SearchCategory

@Factory
class CareerApiDataSource: CareerRemoteDataSource {
    override suspend fun getCareer() = tryCall {
        val careers = RemoteConnection.service.getCareers()
        careers.toDomainModel()
    }
}

private fun List<CareerResponse>.toDomainModel(): List<SearchCategory.Career> = map { it.toDomainModel() }

private fun CareerResponse.toDomainModel(): SearchCategory.Career =
    SearchCategory.Career(name = this.name)
