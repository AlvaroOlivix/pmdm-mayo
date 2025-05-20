package edu.example.pmdm_mayo.feature.client.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val CLIENT_TABLE = "client_table"

@Entity(tableName = CLIENT_TABLE)
data class ClientEntity(
    @PrimaryKey @ColumnInfo(name = "dni") val dni: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
)