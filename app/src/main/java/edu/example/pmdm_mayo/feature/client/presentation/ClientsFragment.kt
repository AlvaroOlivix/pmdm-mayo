package edu.example.pmdm_mayo.feature.client.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.example.pmdm_mayo.databinding.FragmentListClientsBinding
import edu.example.pmdm_mayo.feature.client.presentation.adapter.ClientsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientsFragment : Fragment() {

    private var _binding: FragmentListClientsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClientsViewModel by viewModel()
    private lateinit var adapter: ClientsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListClientsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ClientsAdapter(onCLickDetail = {}, deleteCLick = { viewModel.deleteClient(it) })
        setUpRecycler()
        setUpObserver()
        viewModel.loadClientList()
    }

    private fun setUpObserver() {
        val observer = Observer<ClientsViewModel.CUiState>() {
            if (it.loading) {
                Log.d("@dev", "Cargando lkista de series")
            }
            if (it.error) {
                Log.d("@dev", "Error en la carga de la lista")
            }
            adapter.submitList(it.clients)
            Log.d("@dev", "Recibidos ${it.clients} clientes")
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun setUpRecycler() {
        binding.apply {
            recyclerClients.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerClients.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}