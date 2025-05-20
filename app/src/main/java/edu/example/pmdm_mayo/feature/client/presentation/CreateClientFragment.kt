package edu.example.pmdm_mayo.feature.client.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.example.pmdm_mayo.databinding.ClientFormBinding
import edu.example.pmdm_mayo.databinding.FragmentListClientsBinding
import edu.example.pmdm_mayo.feature.client.domain.Client
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateClientFragment : Fragment() {

    private var _binding: ClientFormBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateClientViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ClientFormBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        bind()
    }

    private fun setUpObserver() {
        val observer = Observer<CreateClientViewModel.CCUiState>() {
            if (it.loading) {
                Log.d("@dev", "Cargando en create")
            }
            if (it.error) {
                Log.d("@dev", "Error en Create")
            }
            if (it.success) {
                Log.d("@dev", "Cargado correctamente")
                findNavController().navigateUp()
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bind() {
        binding.apply {
            // Botón de regreso
            btnBack.setOnClickListener {
                Toast.makeText(requireContext(), "Se ha regresado sin guardar", Toast.LENGTH_LONG)
                    .show()
                findNavController().navigateUp()
            }

            btnSubmit.setOnClickListener {
                val client = Client(
                    dni = binding.etDni.text.toString(),
                    name = binding.etName.text.toString(),
                    email = binding.etEmail.text.toString()
                )
                viewModel.saveClient(client)
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}