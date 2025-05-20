package edu.example.pmdm_mayo.feature.client.domain

import org.koin.core.annotation.Single

@Single
class GetClientByDniUseCase(private val clientRepository: ClientRepository) {
    suspend operator fun invoke(clientDni: String): Client? {
        return clientRepository.getClientByDni(clientDni)
    }
}