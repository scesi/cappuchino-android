package org.scesi.domain.repositories

import org.scesi.domain.models.SearchCategory

interface CareerRepository {
    suspend fun getCareer(): List<SearchCategory.Career>
}