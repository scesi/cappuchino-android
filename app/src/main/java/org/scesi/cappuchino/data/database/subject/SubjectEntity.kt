package org.scesi.cappuchino.data.database.subject

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "subjects")
data class SubjectEntity(
    @PrimaryKey val subjectCode: Int,
    val name: String,
    val madeIn: String?,
    val semester: String?,
    val support: String?,
    val path: String?,
    val url: String?,
    val updatedAt: String?
)

@Entity(
    tableName = "levels",
    primaryKeys = ["levelCode", "subjectCode"]
)
data class LevelEntity(
    val levelCode: String,
    val subjectCode: Int
)

@Entity(tableName = "subject_details")
data class SubjectDetailEntity(
    @PrimaryKey val subjectDetailCode: Int,
    val name: String,
    val levelCode: String,
    val subjectCode: Int
)

@Entity(tableName = "groups")
data class GroupEntity(
    @PrimaryKey(autoGenerate = true) val groupId: Int = 0,
    val groupCode: String,
    val teacher: String?,
    val subjectDetailCode: Int
)

@Entity(tableName = "schedules")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val scheduleId: Int = 0,
    val day: String?,
    val start: String?,
    val end: String?,
    val duration: String?,
    val room: String?,
    val teacher: String?,
    val isClass: Boolean?,
    val groupId: Int
)

data class SubjectWithLevels(
    @Embedded val subject: SubjectEntity,
    @Relation(
        entity = LevelEntity::class,
        parentColumn = "subjectCode",
        entityColumn = "subjectCode"
    )
    val levels: List<LevelWithSubjectDetails>
)

data class LevelWithSubjectDetails(
    @Embedded val level: LevelEntity,
    @Relation(
        entity = SubjectDetailEntity::class,
        parentColumn = "levelCode",
        entityColumn = "levelCode"
    )
    val subjectDetails: List<SubjectDetailWithGroups>
)

data class SubjectDetailWithGroups(
    @Embedded val subjectDetail: SubjectDetailEntity,
    @Relation(
        entity = GroupEntity::class,
        parentColumn = "subjectDetailCode",
        entityColumn = "subjectDetailCode"
    )
    val groups: List<GroupWithSchedules>
)

data class GroupWithSchedules(
    @Embedded val group: GroupEntity,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "groupId"
    )
    val schedules: List<ScheduleEntity>
)
