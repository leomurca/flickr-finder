package xyz.leomurca.flickrfinder.ui.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<PhotoMetadata?>(null)
    val uiState = _uiState.asStateFlow()

    fun setCurrentPhoto(photo: PhotoMetadata) {
        _uiState.value = photo
    }
}