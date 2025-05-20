package edu.example.pmdm_mayo.feature.client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.pmdm_mayo.feature.client.domain.Client
import edu.example.pmdm_mayo.feature.client.domain.SaveClientUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class CreateClientViewModel(private val saveClientUseCase: SaveClientUseCase) : ViewModel() {

    private val _uiState = MutableLiveData(CCUiState())
    val uiState: LiveData<CCUiState> get() = _uiState

    fun saveClient(client: Client) {
        _uiState.value = CCUiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                saveClientUseCase(client)
                _uiState.postValue(CCUiState(success = true))
            } catch (e: Exception) {
                _uiState.postValue(CCUiState(error = true))
            }
        }
    }


    data class CCUiState(
        val loading: Boolean = false,
        val error: Boolean = false,
        val success: Boolean = false
    )
}