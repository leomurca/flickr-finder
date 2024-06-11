package xyz.leomurca.flickrfinder.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.model.PhotoResult
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        searchPhotos()
    }

    fun onSearchQueryChange(text: String) {
        _searchQuery.value = text
        searchPhotos()
    }

    private fun searchPhotos() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = photoRepository.search(_searchQuery.value).map {
                when (it) {
                    is PhotoResult.Success -> UiState.Loaded.Success(it.data)
                    is PhotoResult.Error -> UiState.Loaded.Error(it.message)
                }
            }.first()
        }
    }

    sealed interface UiState {
        data object Loading : UiState

        sealed class Loaded : UiState {
            data class Success(val photos: List<PhotoMetadata>) : Loaded()
            data class Error(val message: String) : Loaded()
        }
    }
}
