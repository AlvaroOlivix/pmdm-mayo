package edu.example.pmdm_mayo.feature.client.data.remote

import edu.example.pmdm_mayo.feature.client.domain.Client
import org.koin.core.annotation.Single

@Single
class RemoteMockDataSource {

    private val mockClientes = listOf(
        Client(dni = "12345678A", name = "María López", email = "maria.lopez@example.com"),
        Client(dni = "87654321B", name = "Carlos García", email = "carlos.garcia@example.com"),
        Client(dni = "11223344C", name = "Lucía Fernández", email = "lucia.fernandez@example.com")
    )

    fun getAll(): List<Client> {
        return mockClientes
    }

    fun getClientById(clientDni: String): Client? {
        return mockClientes.find { it.dni == clientDni }
    }

}