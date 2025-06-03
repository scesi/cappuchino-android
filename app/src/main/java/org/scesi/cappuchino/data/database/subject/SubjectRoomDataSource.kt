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
            val subjectWithLevels = subjectDao.getSubjectWithLevels(code, path)
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
        code = subject.subjectCode,
        name = subject.name.orEmpty(),
        url = subject.url.orEmpty(),
        updatedAt = subject.updatedAt.orEmpty(),
        levels = levels.map { levelWithSubjects ->
            SearchCategory.Level(
                code = levelWithSubjects.level.levelCode,
                subjects = levelWithSubjects.subjectDetails.map { subjectDetailWithGroups ->
                    SearchCategory.DomainSubject(
                        code = subjectDetailWithGroups.subjectDetail.subjectDetailCode,
                        name = subjectDetailWithGroups.subjectDetail.name,
                        groups = subjectDetailWithGroups.groups.map { groupWithSchedule ->
                            SearchCategory.Group(
                                code = groupWithSchedule.group.groupCode,
                                teacher = groupWithSchedule.group.teacher.orEmpty(),
                                schedule = groupWithSchedule.schedules.map { sched ->
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
    subjectCode = this.code,
    name = this.name,
    madeIn = this.madeIn,
    semester = this.semester,
    support = this.support,
    path = this.path,
    url = this.url,
    updatedAt = this.updatedAt
)

fun SearchCategory.Level.toEntity(subjectCode: Int): LevelEntity = LevelEntity(
    levelCode = this.code,
    subjectCode = subjectCode
)

fun SearchCategory.DomainSubject.toEntity(levelCode: String, subjectCode: Int): SubjectDetailEntity = SubjectDetailEntity(
    subjectDetailCode = this.code,
    name = this.name,
    levelCode = levelCode,
    subjectCode = subjectCode
)

fun SearchCategory.Group.toEntity(subjectDetailCode: Int): GroupEntity = GroupEntity(
    groupCode = this.code,
    teacher = this.teacher,
    subjectDetailCode = subjectDetailCode
)

fun SearchCategory.Schedule.toEntity(groupId: Int): ScheduleEntity = ScheduleEntity(
    day = this.day,
    start = this.start,
    end = this.end,
    duration = this.duration,
    room = this.room,
    teacher = this.teacher,
    isClass = this.isClass,
    groupId = groupId
)
