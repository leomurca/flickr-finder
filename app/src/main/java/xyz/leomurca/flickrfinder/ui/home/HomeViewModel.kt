package xyz.leomurca.flickrfinder.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    photoRepository: PhotoRepository
) : ViewModel() {
    val uiState: StateFlow<UiState> =
        photoRepository.search(emptyList()).map {
            UiState.Loaded(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Loading,
        )

    sealed interface UiState {
        data object Loading : UiState

        data class Loaded(val photos: List<PhotoMetadata>) : UiState
    }
}
