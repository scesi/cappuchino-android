package org.scesi.cappuchino.data.database.subject

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity(tableName = "subjects")
data class SubjectEntity(
    @PrimaryKey val code: Int,
    val name: String,
    val madeIn: String?,
    val semester: String?,
    val support: String?,
    val path: String?,
    val url: String?,
    val updatedAt: String?
)

@Entity(tableName = "level")
data class LevelEntity(
    @PrimaryKey val codeLevel: String,
    val subjectCode: Int
)

@Entity(tableName = "subjects_detail")
data class SubjectDetailEntity(
    @PrimaryKey val codeDetail: Int,
    val name: String,
    val levelCode: String
)

@Entity(tableName = "group")
data class GroupEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val codeGroup: String,
    val teacher: String?,
    val subjectCode: Int
)

@Entity(tableName = "schedule")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val day: String?,
    val start: String?,
    val end: String?,
    val duration: String?,
    val room: String?,
    val teacher: String?,
    val isClass: Boolean?,
    val groupCode: String
)

data class SubjectWithLevels(
    @Embedded val subject: SubjectEntity,
    @Relation(
        entity = LevelEntity::class,
        parentColumn = "code",
        entityColumn = "subjectCode"
    )
    val levels: List<LevelWithSubjects>
)

data class LevelWithSubjects(
    @Embedded val level: LevelEntity,
    @Relation(
        entity = SubjectDetailEntity::class,
        parentColumn = "codeLevel",
        entityColumn = "levelCode"
    )
    val subjects: List<SubjectDetailWithGroups>
)

data class SubjectDetailWithGroups(
    @Embedded val subject: SubjectDetailEntity,
    @Relation(
        entity = GroupEntity::class,
        parentColumn = "codeDetail",
        entityColumn = "subjectCode"
    )
    val groups: List<GroupWithSchedule>
)

data class GroupWithSchedule(
    @Embedded val group: GroupEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "groupCode"
    )
    val schedule: List<ScheduleEntity>
)
