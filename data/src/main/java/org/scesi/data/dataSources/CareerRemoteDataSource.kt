package org.scesi.data.dataSources

import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory

interface CareerRemoteDataSource {
    suspend fun getCareer(): CapResult<List<SearchCategory.Career>, CapError>
    suspend fun getListOfSubjects(code: String, path: String): CapResult<SearchCategory.Subject, CapError>
}