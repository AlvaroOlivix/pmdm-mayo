package edu.example.pmdm_mayo.feature.core.db

import android.content.Context
import androidx.room.Room

object DbProvider {
    fun provideDatabase(context: Context): ClientDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            ClientDataBase::class.java,
            "app_database"
        ).build()
    }
}