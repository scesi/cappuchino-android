package org.scesi.cappuchino

import android.app.Application

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        initDependencyInjection()
    }
}