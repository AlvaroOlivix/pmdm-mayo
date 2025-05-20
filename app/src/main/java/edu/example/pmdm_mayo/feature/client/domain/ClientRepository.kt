package edu.example.pmdm_mayo.feature.client.domain

interface ClientRepository {
    suspend fun getAll():List<Client>
    suspend fun getClientByDni(clientDni:String):Client?
    suspend fun deleteCLient(client:Client)
}