package org.scesi.data.repositories

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.CareerRemoteDataSource
import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory
import org.scesi.domain.repositories.CareerRepository
import javax.inject.Inject

@Factory
class CareerRepositoryImpl @Inject constructor(
    private val careerRemoteDataSource: CareerRemoteDataSource
):CareerRepository {
    override suspend fun getCareer(): CapResult<List<SearchCategory.Career>, CapError> {
        return careerRemoteDataSource.getCareer()
    }
}