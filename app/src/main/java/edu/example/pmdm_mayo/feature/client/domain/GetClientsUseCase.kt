package edu.example.pmdm_mayo.feature.client.domain

import android.util.Log
import org.koin.core.annotation.Single

@Single
class GetClientsUseCase(private val clientRepository: ClientRepository) {
    suspend operator fun invoke(): List<Client> {
        val clientes = clientRepository.getAll()
        Log.d("@ev","$clientes")
        return clientes
    }
}