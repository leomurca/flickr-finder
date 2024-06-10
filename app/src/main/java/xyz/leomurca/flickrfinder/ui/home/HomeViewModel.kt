package xyz.leomurca.flickrfinder.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val text = "Hello FlickrFinder!"
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Text(viewModel.text)
}
