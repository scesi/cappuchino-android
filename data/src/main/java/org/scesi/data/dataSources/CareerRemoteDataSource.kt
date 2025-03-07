package org.scesi.data.dataSources

import org.scesi.domain.models.SearchCategory

interface CareerRemoteDataSource {
    suspend fun getCareer(): List<SearchCategory.Career>
}