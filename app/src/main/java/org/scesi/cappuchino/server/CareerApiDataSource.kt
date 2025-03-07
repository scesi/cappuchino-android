package org.scesi.cappuchino.server

import android.util.Log
import org.koin.core.annotation.Factory
import org.scesi.cappuchino.server.models.SearchCategory
import org.scesi.data.dataSources.CareerRemoteDataSource
import org.scesi.domain.models.Career

@Factory
class CareerApiDataSource: CareerRemoteDataSource {
    override suspend fun getCareer() = tryCall {
        Log.d("CareerApiDataSource", "Iniciando llamada a la API")
        val careers = RemoteConnection.service.getCareers()
        Log.d("CareerApiDataSource", "Respuesta de la API: $careers")
        careers.map { it.toDomainModel() }
    }
}

private fun SearchCategory.RemoteCareer.toDomainModel(): Career = Career(name = this.name)
