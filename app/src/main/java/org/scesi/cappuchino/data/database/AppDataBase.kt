package org.scesi.cappuchino.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.scesi.cappuchino.data.database.career.Career
import org.scesi.cappuchino.data.database.career.CareerDao
import org.scesi.cappuchino.data.database.subject.GroupEntity
import org.scesi.cappuchino.data.database.subject.LevelEntity
import org.scesi.cappuchino.data.database.subject.ScheduleEntity
import org.scesi.cappuchino.data.database.subject.SubjectDao
import org.scesi.cappuchino.data.database.subject.SubjectDetailEntity
import org.scesi.cappuchino.data.database.subject.SubjectEntity

@Database(
    entities = [Career::class, SubjectEntity::class, LevelEntity::class, SubjectDetailEntity::class,
        GroupEntity::class, ScheduleEntity::class], version = 14, exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun careerDao(): CareerDao
    abstract fun subjectDao(): SubjectDao
}