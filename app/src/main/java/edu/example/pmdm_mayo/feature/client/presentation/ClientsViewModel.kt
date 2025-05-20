package edu.example.pmdm_mayo.feature.client.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.pmdm_mayo.feature.client.domain.Client
import edu.example.pmdm_mayo.feature.client.domain.DeleteClientUseCase
import edu.example.pmdm_mayo.feature.client.domain.GetClientsUseCase
import edu.example.pmdm_mayo.feature.client.domain.SaveClientUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ClientsViewModel(
    private val getClientList: GetClientsUseCase,
    private val deleteCLientUseCase: DeleteClientUseCase,
    private val saveClientUseCase: SaveClientUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData(CUiState())
    val uiState: LiveData<CUiState> get() = _uiState
    private var clientsL: List<Client> = emptyList()

    fun loadClientList() {
        _uiState.value = CUiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                clientsL = getClientList()
                _uiState.postValue(CUiState(clients = clientsL))
                Log.d("@dev", "Lista cargada = $clientsL")
            } catch (e: Exception) {
                _uiState.postValue(CUiState(error = true))
                Log.e("@dev", e.message.toString())
            }
        }
    }

    fun deleteClient(client: Client) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteCLientUseCase(client)
            val listPostDelete = getClientList()
            _uiState.postValue(CUiState(clients = listPostDelete))// recarga la lista después del borrado
        }
    }


    data class CUiState(
        val clients: List<Client> = emptyList(),
        val loading: Boolean = false, val error: Boolean = false
    )
}