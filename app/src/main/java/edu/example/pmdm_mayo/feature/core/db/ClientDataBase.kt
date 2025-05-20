package edu.example.pmdm_mayo.feature.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.example.pmdm_mayo.feature.client.data.local.ClientDao
import edu.example.pmdm_mayo.feature.client.data.local.ClientEntity

@Database(entities = [ClientEntity::class], version = 1, exportSchema = false)
abstract class ClientDataBase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
}