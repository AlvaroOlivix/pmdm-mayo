package edu.example.pmdm_mayo.feature.client.presentation.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import edu.example.pmdm_mayo.databinding.ItemClientBinding
import edu.example.pmdm_mayo.feature.client.domain.Client

class ClientsViewHolder(private val binding: ItemClientBinding) : ViewHolder(binding.root) {
    fun bind(client: Client, onCLickDetail: (Client) -> Unit, deleteClick: (Client) -> Unit) {
        binding.apply {
            clientDni.text = client.dni
            clientName.text = client.name
            clientEmail.text = client.email
            trash.setOnClickListener {
                deleteClick(client)
            }
        }
    }
}