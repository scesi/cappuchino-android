package org.scesi.cappuchino.data.database

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.CareerLocalDataSource
import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory

@Factory
class CareerRoomDataSource(
    private val careerDao: CareerDao

) : CareerLocalDataSource {

    override suspend fun getCareers(): CapResult<List<SearchCategory.Career>, CapError> {
        return try {
            val careers = careerDao.getAll().map { it.toDomainModel() }
            CapResult.Success(careers)
        } catch (e: Exception) {
            CapResult.Error(CapError.Unknown(e.message ?: "Unknown error"))
        }
    }


    override suspend fun saveCareers(careers: List<SearchCategory.Career>) {
        careerDao.insertCareers(careers.map { it.toEntity() })
    }

}


fun Career.toDomainModel(): SearchCategory.Career =
    SearchCategory.Career(
        name = this.name,
        code = this.code,
        path = this.path
    )

fun SearchCategory.Career.toEntity(): Career =
    Career(name = this.name, code = this.code, path = this.path)
