package org.scesi.cappuchino.data.server

import org.koin.core.annotation.Factory
import org.scesi.cappuchino.data.server.models.CareerResponse
import org.scesi.cappuchino.data.server.models.LevelsResponse
import org.scesi.cappuchino.data.server.models.SubjectResponse
import org.scesi.cappuchino.data.tryCall
import org.scesi.data.dataSources.CareerRemoteDataSource
import org.scesi.domain.models.SearchCategory

@Factory
class CareerApiDataSource: CareerRemoteDataSource {
    private val service = RemoteConnection.service

    override suspend fun getCareer() = tryCall {
        val response = service.getCareers()
        response.toDomainModel()
    }

    override suspend fun getListOfSubjects(code: String, path: String) = tryCall {
        val response = service.getSubjects(careerPath = path, subjectCode = code)
        response.toDomainModel()
    }


    private fun List<CareerResponse>.toDomainModel(): List<SearchCategory.Career> =
        map { it.toDomainModel() }

    private fun CareerResponse.toDomainModel(): SearchCategory.Career =
        SearchCategory.Career(
            name = this.name,
            code = this.code,
            path = this.path
        )


    private fun SubjectResponse.toDomainModel(): SearchCategory.Subject =
        SearchCategory.Subject(
            madeIn = this.madeIn.orEmpty(),
            semester = this.semester.orEmpty(),
            support = this.support.orEmpty(),
            path = this.path.orEmpty(),
            code = this.code ?: 0,
            name = this.name.orEmpty(),
            url = this.url.orEmpty(),
            updatedAt = this.updatetAt.orEmpty(),
            levels = this.levels.toLevelDomainModel()
        )

    private fun List<LevelsResponse>.toLevelDomainModel(): List<SearchCategory.Level> =
        map { level ->
            SearchCategory.Level(
                code = level.code.orEmpty(),
                subjects = level.subjects.map { subject ->
                    SearchCategory.DomainSubject(
                        code = subject.code ?: 0,
                        name = subject.name.orEmpty(),
                        groups = subject.groups.map { group ->
                            SearchCategory.Group(
                                code = group.code.orEmpty(),
                                teacher = group.teacher.orEmpty(),
                                schedule = group.schedule.map { schedule ->
                                    SearchCategory.Schedule(
                                        day = schedule.day.orEmpty(),
                                        start = schedule.start.orEmpty(),
                                        end = schedule.end.orEmpty(),
                                        room = schedule.room.orEmpty(),
                                        isClass = schedule.isClass ?: false
                                    )
                                }
                            )
                        }
                    )
                }
            )
        }

}