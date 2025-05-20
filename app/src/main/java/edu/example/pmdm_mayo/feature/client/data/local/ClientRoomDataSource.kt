package edu.example.pmdm_mayo.feature.client.data.local

import edu.example.pmdm_mayo.feature.client.domain.Client
import org.koin.core.annotation.Single


@Single
class ClientRoomDataSource(private val clientDao: ClientDao) {

    fun saveClient(client: Client) {
        clientDao.insertClient(client.toEntity())
    }

    fun saveCLientList(clients: List<Client>) {
        clientDao.insertAll(*clients.map { it.toEntity() }.toTypedArray())
    }

    suspend fun getAll(): List<Client> {
        return clientDao.getAll().map { it.toModel() }
    }

    suspend fun getClientByDni(clientDni: String): Client? {
        return clientDao.getClientByDni(clientDni).toModel()
    }
    suspend fun deleteClient(client: Client) {
        clientDao.deleteClient(client.toEntity())
    }

}