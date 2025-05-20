package edu.example.pmdm_mayo.feature.client.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import edu.example.pmdm_mayo.feature.client.domain.Client

class ClientsDiffUtil : DiffUtil.ItemCallback<Client>() {
    override fun areItemsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem.dni == newItem.dni
    }

    override fun areContentsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem == newItem
    }
}