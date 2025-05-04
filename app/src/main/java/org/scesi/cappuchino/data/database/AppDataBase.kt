package org.scesi.cappuchino.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Career::class], version = 1, exportSchema = false)
abstract class CareerDataBase: RoomDatabase() {

    abstract fun careerDao(): CareerDao

    companion object {
        @Volatile
        private var INSTANCE: CareerDataBase? = null

        fun getDatabase(context: Context): CareerDataBase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CareerDataBase::class.java,
                    "career_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}