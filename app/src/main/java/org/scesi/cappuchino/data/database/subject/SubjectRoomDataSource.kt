package org.scesi.cappuchino.data.database.subject

import org.koin.core.annotation.Factory
import org.scesi.data.dataSources.SubjectLocalDataSource
import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory

@Factory
class SubjectRoomDataSource(
    private val subjectDao: SubjectDao,
) : SubjectLocalDataSource {
    override suspend fun getSubjects(
        code: String,
        path: String
    ): CapResult<SearchCategory.Subject, CapError> {
        return try {
            println(">>> Buscando en Room: code=$code, path='$path'")
            val subjectWithLevels = subjectDao.getSubjectWithLevels(code, path)
            println(">>> Resultado Room: $subjectWithLevels")
            if (subjectWithLevels == null) {
                CapResult.Error(CapError.NotFound)
            } else {
                CapResult.Success(subjectWithLevels.toDomain())
            }
        } catch (e: Exception) {
            CapResult.Error(CapError.Unknown(e.message ?: "Unknown error"))
        }
    }

    override suspend fun saveSubjects(subjects: SearchCategory.Subject) {
        subjectDao.insertFullSubject(subjects)
    }


}
fun SubjectWithLevels.toDomain(): SearchCategory.Subject {
    return SearchCategory.Subject(
        madeIn = subject.madeIn.orEmpty(),
        semester = subject.semester.orEmpty(),
        support = subject.support.orEmpty(),
        path = subject.path.orEmpty(),
        code = subject.code,
        name = subject.name.orEmpty(),
        url = subject.url.orEmpty(),
        updatedAt = subject.updatedAt.orEmpty(),
        levels = levels.map { levelWithSubjects ->
            SearchCategory.Level(
                code = levelWithSubjects.level.codeLevel.orEmpty(),
                subjects = levelWithSubjects.subjects.map { subjectDetailWithGroups ->
                    SearchCategory.DomainSubject(
                        code = subjectDetailWithGroups.subject.codeDetail,
                        name = subjectDetailWithGroups.subject.name,
                        groups = subjectDetailWithGroups.groups.map { groupWithSchedule ->
                            SearchCategory.Group(
                                code = groupWithSchedule.group.codeGroup,
                                teacher = groupWithSchedule.group.teacher.orEmpty(),
                                schedule = groupWithSchedule.schedule.map { sched ->
                                    SearchCategory.Schedule(
                                        day = sched.day.orEmpty(),
                                        start = sched.start.orEmpty(),
                                        end = sched.end.orEmpty(),
                                        room = sched.room.orEmpty(),
                                        duration = sched.duration.orEmpty(),
                                        teacher = sched.teacher.orEmpty(),
                                        isClass = sched.isClass ?: false
                                    )
                                }
                            )
                        }
                    )
                }
            )
        }
    )
}

fun SearchCategory.Subject.toEntity(): SubjectEntity = SubjectEntity(
    code = this.code,
    name = this.name,
    madeIn = this.madeIn,
    semester = this.semester,
    support = this.support,
    path = this.path,
    url = this.url,
    updatedAt = this.updatedAt
)

fun SearchCategory.Level.toEntity(subjectCode: Int): LevelEntity = LevelEntity(
    codeLevel = this.code,
    subjectCode = subjectCode
)

fun SearchCategory.DomainSubject.toEntity(codeLevel: String): SubjectDetailEntity = SubjectDetailEntity(
    codeDetail = this.code,
    name = this.name,
    levelCode = codeLevel
)

fun SearchCategory.Group.toEntity(subjectCode: Int): GroupEntity = GroupEntity(
    codeGroup = this.code,
    teacher = this.teacher,
    subjectCode = subjectCode
)

fun SearchCategory.Schedule.toEntity(groupCode: String): ScheduleEntity = ScheduleEntity(
    day = this.day,
    start = this.start,
    end = this.end,
    duration = this.duration,
    room = this.room,
    teacher = this.teacher,
    isClass = this.isClass,
    groupCode = groupCode
)
