package org.scesi.cappuchino.data.database.career

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Career")
data class Career(
    @PrimaryKey(autoGenerate = true) val code: Int,
    val name: String,
    val path: String
)
