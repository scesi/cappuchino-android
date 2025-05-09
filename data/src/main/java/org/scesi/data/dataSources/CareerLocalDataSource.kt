package org.scesi.data.dataSources

import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory

interface CareerLocalDataSource{
    suspend fun getCareers(): CapResult<List<SearchCategory.Career>, CapError>
    suspend fun saveCareers(careers: List<SearchCategory.Career>)

}