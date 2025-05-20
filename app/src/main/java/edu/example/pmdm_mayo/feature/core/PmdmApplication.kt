package edu.example.pmdm_mayo.feature.core

import android.app.Application
import edu.example.pmdm_mayo.feature.core.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class PmdmApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PmdmApplication)
            modules(AppModule().module)
        }
    }
}