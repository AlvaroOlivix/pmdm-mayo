package edu.example.pmdm_mayo.feature.client.domain

import org.koin.core.annotation.Single

@Single
class SaveClientUseCase(private val clientRepository: ClientRepository) {
    suspend operator fun invoke(client: Client){
        clientRepository.saveClient(client)
    }
}