package edu.example.pmdm_mayo.feature.client.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.example.pmdm_mayo.databinding.ClientFormBinding
import edu.example.pmdm_mayo.databinding.FragmentListClientsBinding

class CreateClientFragment :Fragment(){

    private var _binding: ClientFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ClientFormBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}