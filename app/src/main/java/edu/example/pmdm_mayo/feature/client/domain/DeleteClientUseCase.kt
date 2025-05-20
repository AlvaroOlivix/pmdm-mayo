package edu.example.pmdm_mayo.feature.client.domain

import org.koin.core.annotation.Single

@Single
class DeleteClientUseCase(private val clientRepository: ClientRepository) {
    suspend operator fun invoke(client:Client){
        clientRepository.deleteCLient(client)
    }
}