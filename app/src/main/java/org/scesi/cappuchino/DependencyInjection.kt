package org.scesi.cappuchino

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.ksp.generated.module
import org.scesi.data.DataModule
import org.scesi.usescases.UseCaseModule

fun Application.initDependencyInjection() {
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@initDependencyInjection)
        modules(AppModule().module,DataModule().module, UseCaseModule().module)
    }
}