package org.scesi.cappuchino

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.ksp.generated.module
import org.scesi.cappuchino.data.database.AppDataBase
import org.scesi.cappuchino.data.database.CareerDao
import org.scesi.data.DataModule
import org.scesi.usescases.UseCaseModule

fun Application.initDependencyInjection() {
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@initDependencyInjection)
        modules(AppModule().module,DataModule().module, UseCaseModule().module)
    }
}
@Module
@ComponentScan
class AppModule{
    @Single
    fun provideDatabase(application: Application): AppDataBase =
        Room.databaseBuilder(
            application,
            AppDataBase::class.java,
            "app_database"
        ).build()
    @Single
    fun provideCareerDao(db: AppDataBase): CareerDao = db.careerDao()
}