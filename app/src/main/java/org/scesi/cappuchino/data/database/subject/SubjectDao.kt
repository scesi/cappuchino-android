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
    @Transaction
    @Query("SELECT * FROM subjects WHERE code = :code AND path = :path")
    suspend fun getSubjectWithLevels(code: String, path: String): SubjectWithLevels?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: SubjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevel(level: LevelEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjectDetail(subject: SubjectDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: GroupEntity)

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
                val subjectDetailEntity = domainSubject.toEntity(level.code)
                insertSubjectDetail(subjectDetailEntity)

                domainSubject.groups.forEach { group ->
                    val groupEntity = group.toEntity(domainSubject.code)
                    insertGroup(groupEntity)

                    group.schedule.forEach { schedule ->
                        val scheduleEntity = schedule.toEntity(group.code)
                        insertSchedule(scheduleEntity)
                    }
                }
            }
        }
    }

}

