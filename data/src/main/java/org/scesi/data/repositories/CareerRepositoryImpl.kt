package org.scesi.data.repositories

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.CareerRemoteDataSource
import org.scesi.domain.models.Career
import org.scesi.domain.repositories.CareerRepository
import javax.inject.Inject

@Factory
class CareerRepositoryImpl @Inject constructor(
    private val careerRemoteDataSource: CareerRemoteDataSource
):CareerRepository {
    override suspend fun getCareer(): List<Career> {
        return careerRemoteDataSource.getCareer()
    }
}