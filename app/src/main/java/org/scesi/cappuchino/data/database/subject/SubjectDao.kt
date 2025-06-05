package org.scesi.cappuchino.data.database.subject


import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.scesi.domain.models.SearchCategory

@Dao
interface SubjectDao {
    suspend fun buildSubjectWithLevels(code: Int): SubjectWithLevels? {
        val subject = getSubject(code) ?: return null

        val levels = getLevels(subject.subjectCode).map { level ->
            val subjectDetails =
                getSubjectDetails(level.levelCode, subject.subjectCode).map { detail ->
                    val groups =
                        getGroups(detail.subjectDetailCode, subject.subjectCode).map { group ->
                            val schedules = getSchedules(
                                group.groupCode,
                                detail.subjectDetailCode,
                                subject.subjectCode
                            )
                            GroupWithSchedules(group, schedules)
                        }
                    SubjectDetailWithGroups(detail, groups)
                }
            LevelWithSubjectDetails(level, subjectDetails)
        }
        return SubjectWithLevels(subject, levels)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: SubjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevel(level: LevelEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjectDetail(subject: SubjectDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: GroupEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(schedule: ScheduleEntity)

    @Transaction
    suspend fun insertFullSubject(subject: SearchCategory.Subject) {
        val subjectEntity = subject.toEntity()
        insertSubject(subjectEntity)

        subject.levels.forEach { level ->
            val levelEntity = level.toEntity(subject.code)
            insertLevel(levelEntity)
            level.subjects.forEach { domainSubject ->
                val subjectDetailEntity = domainSubject.toEntity(level.code, subject.code)
                insertSubjectDetail(subjectDetailEntity)
                domainSubject.groups.forEach { group ->
                    val groupEntity = group.toEntity(domainSubject.code, subject.code)
                    insertGroup(groupEntity).toInt()
                    group.schedule.forEach { schedule ->
                        insertSchedule(
                            schedule.toEntity(
                                group = group,
                                subjectDetailCode = domainSubject.code,
                                subjectCode = subject.code
                            )
                        )
                    }
                }
            }
        }

    }

    @Query("SELECT * FROM subjects WHERE subjectCode = :code")
    suspend fun getSubject(code: Int): SubjectEntity?

    @Query("SELECT * FROM levels WHERE subjectCode = :code")
    suspend fun getLevels(code: Int): List<LevelEntity>

    @Query("SELECT * FROM subject_details WHERE levelCode = :levelCode AND subjectCode = :subjectCode")
    suspend fun getSubjectDetails(levelCode: String, subjectCode: Int): List<SubjectDetailEntity>

    @Query("SELECT * FROM groups WHERE subjectDetailCode = :subjectDetailCode AND subjectCode = :subjectCode")
    suspend fun getGroups(subjectDetailCode: Int, subjectCode: Int): List<GroupEntity>

    @Query(
        """
        SELECT * FROM schedules 
        WHERE groupCode = :groupCode 
        AND subjectDetailCode = :subjectDetailCode 
        AND subjectCode = :subjectCode
    """
    )
    suspend fun getSchedules(
        groupCode: String,
        subjectDetailCode: Int,
        subjectCode: Int
    ): List<ScheduleEntity>
}

