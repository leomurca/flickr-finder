package xyz.leomurca.flickrfinder.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.model.PhotoResult
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    photoRepository: PhotoRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    val uiState: StateFlow<UiState> =
        photoRepository.search(emptyList()).map {
            when (it) {
                is PhotoResult.Success -> UiState.Loaded.Success(it.data)
                is PhotoResult.Error -> UiState.Loaded.Error(it.message)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Loading,
        )


    fun onSearchQueryChange(text: String) {
        _searchQuery.value = text
    }

    sealed interface UiState {
        data object Loading : UiState

        sealed class Loaded : UiState {
            data class Success(val photos: List<PhotoMetadata>) : Loaded()
            data class Error(val message: String) : Loaded()
        }
    }
}
