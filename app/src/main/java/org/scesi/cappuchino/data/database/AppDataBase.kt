package org.scesi.cappuchino.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Career::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun careerDao(): CareerDao
}