package org.scesi.domain.repositories

import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory


interface CareerRepository {
    suspend fun getCareer(): CapResult<List<SearchCategory.Career>, CapError>
}