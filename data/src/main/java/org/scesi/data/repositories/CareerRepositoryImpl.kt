package org.scesi.data.repositories

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.CareerLocalDataSource
import org.scesi.data.dataSources.CareerRemoteDataSource
import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory
import org.scesi.domain.repositories.CareerRepository
import javax.inject.Inject

@Factory
class CareerRepositoryImpl @Inject constructor(
    private val remote: CareerRemoteDataSource,
    private val local: CareerLocalDataSource

):CareerRepository {
    override suspend fun getCareer(): CapResult<List<SearchCategory.Career>, CapError> {
        return when (val result = remote.getCareer()) {
            is CapResult.Success -> {
                local.saveCareers(result.data)
                result
            }

            is CapResult.Error -> {
                when (val localResult = local.getCareers()) {
                    is CapResult.Success -> {
                        CapResult.Success(localResult.data)
                    }

                    is CapResult.Error -> {
                        CapResult.Error(result.error)
                    }
                }
            }
        }
    }

    override suspend fun getListOfSubjects(
        code: String,
        path: String
    ): CapResult<SearchCategory.Subject, CapError> {
        return remote.getListOfSubjects(code, path)
    }

}