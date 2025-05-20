package edu.example.pmdm_mayo.feature.client.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.example.pmdm_mayo.databinding.ItemClientBinding
import edu.example.pmdm_mayo.feature.client.domain.Client

class ClientsAdapter(private val onCLickDetail: (Client) -> Unit,private val deleteCLick: (Client) -> Unit) :
    ListAdapter<Client, ClientsViewHolder>(ClientsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientsViewHolder {
        val binding = ItemClientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClientsViewHolder, position: Int) {
        val client = getItem(position)
        holder.bind(client, onCLickDetail, deleteCLick)
    }
}