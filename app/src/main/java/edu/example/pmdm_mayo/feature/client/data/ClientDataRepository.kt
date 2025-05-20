package edu.example.pmdm_mayo.feature.client.data

import edu.example.pmdm_mayo.feature.client.data.local.ClientRoomDataSource
import edu.example.pmdm_mayo.feature.client.data.remote.RemoteMockDataSource
import edu.example.pmdm_mayo.feature.client.domain.Client
import edu.example.pmdm_mayo.feature.client.domain.ClientRepository
import org.koin.core.annotation.Single

@Single
class ClientDataRepository(
    private val localClientDataRepository: ClientRoomDataSource,
    private val remoteMock: RemoteMockDataSource
) : ClientRepository {
    override suspend fun getAll(): List<Client> {

        val localData = localClientDataRepository.getAll()
        if (localData.isEmpty()) {
            val remoteData = remoteMock.getAll()
            localClientDataRepository.saveCLientList(remoteData)
            return remoteData
        }
        return localData

    }

    override suspend fun getClientByDni(clientDni: String): Client? {


        val localData = localClientDataRepository.getClientByDni(clientDni)
        if (localData == null) {
            val remoteD = remoteMock.getClientById(clientDni)
            if (remoteD != null) {
                localClientDataRepository.saveClient(remoteD)
            }
            return remoteD
        }
        return localData
    }

    override suspend fun deleteCLient(client: Client) {
        localClientDataRepository.deleteClient(client)
    }

    override suspend fun saveClient(client: Client) {
        localClientDataRepository.saveClient(client)
    }

}