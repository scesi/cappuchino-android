package org.scesi.domain.repositories

import org.scesi.domain.models.Career

interface CareerRepository {
    suspend fun getCareer(): List<Career>
}