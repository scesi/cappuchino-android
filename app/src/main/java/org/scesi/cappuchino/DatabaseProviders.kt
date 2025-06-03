package org.scesi.cappuchino

import android.app.Application
import androidx.room.Room
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.scesi.cappuchino.data.database.AppDataBase
import org.scesi.cappuchino.data.database.career.CareerDao

@Module
class DatabaseProviders {

    @Single
    fun provideDatabase(application: Application): AppDataBase =
        Room.databaseBuilder(
            application,
            AppDataBase::class.java,
            "app_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Single
    fun provideCareerDao(db: AppDataBase): CareerDao = db.careerDao()

    @Single
    fun provideSubjectDao(db: AppDataBase) = db.subjectDao()
}
