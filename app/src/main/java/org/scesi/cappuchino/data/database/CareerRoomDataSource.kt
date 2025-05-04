package org.scesi.cappuchino.data.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.CareerLocalDataSource
import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory

@Factory
class CareerRoomDataSource(
    private val dao: CareerDao

) : CareerLocalDataSource {
    init {
        println("✅ CareerRoomDataSource has been created")
    }

    override suspend fun getCareers(): CapResult<List<SearchCategory.Career>, CapError> {
        return try {
            val careers = dao.getAll().first().map { it.toDomainModel() }
            CapResult.Success(careers)
        } catch (e: Exception) {
            CapResult.Error(CapError.Unknown(e.message ?: "Unknown error"))
        }
    }




    override suspend fun saveCareers(careers: List<SearchCategory.Career>) {
        withContext(Dispatchers.IO) {
            dao.insertCareers(careers.map { it.toEntity() })
        }
    }

}


fun Career.toDomainModel(): SearchCategory.Career =
    SearchCategory.Career(name = this.name)

fun SearchCategory.Career.toEntity(): Career =
    Career(name = this.name, code = 0, semester = "", path = "")
