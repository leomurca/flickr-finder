package xyz.leomurca.flickrfinder.ui.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.uiState.collectAsState()

    when (val value = state.value) {
        is HomeViewModel.UiState.Loaded -> {
            LazyColumn {
                items(value.photos) {
                    AsyncImage(
                        model = it.media,
                        contentDescription = it.description,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )
                    Text(text = it.title)
                }
            }
        }

        is HomeViewModel.UiState.Loading -> {
            Text("Loading...")
        }
    }
}