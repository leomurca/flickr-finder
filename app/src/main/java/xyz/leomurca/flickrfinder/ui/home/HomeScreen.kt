package xyz.leomurca.flickrfinder.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.uiState.collectAsState()

    when (val value = state.value) {
        is HomeViewModel.UiState.Loaded -> {
            LazyColumn {
                items(value.photos) {
                    Text(text = it.title)
                }
            }
        }

        is HomeViewModel.UiState.Loading -> {
            Text("Loading...")
        }
    }
}