package edu.example.pmdm_mayo.feature.client.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.example.pmdm_mayo.feature.client.domain.Client

@Dao
interface ClientDao {

    @Query("SELECT * FROM client_table")
    fun getAll(): List<ClientEntity>

    @Query("SELECT * FROM client_table WHERE dni = :clientDni")
    fun getClientByDni(clientDni: String): ClientEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg clients: ClientEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClient(client: ClientEntity)
    @Delete
    suspend fun deleteClient(client: ClientEntity)
}
