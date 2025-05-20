package edu.example.pmdm_mayo.feature.client.data.local

import edu.example.pmdm_mayo.feature.client.domain.Client

fun Client.toEntity(): ClientEntity {
    return ClientEntity(this.dni, this.name, this.email)
}

fun ClientEntity.toModel(): Client {
    return Client(this.dni, this.name, this.email)
}