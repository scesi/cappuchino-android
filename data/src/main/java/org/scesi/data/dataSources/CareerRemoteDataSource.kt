package org.scesi.data.dataSources

import org.scesi.domain.models.Career

interface CareerRemoteDataSource {
    suspend fun getCareer(): List<Career>
}