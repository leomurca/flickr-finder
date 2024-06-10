package xyz.leomurca.flickrfinder.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.uiState.collectAsState()
    val searchQuery = viewModel.searchQuery.collectAsState()

    when (val value = state.value) {
        is HomeViewModel.UiState.Loaded -> {
            Column {
                SearchBar(
                    query = searchQuery.value,
                    onQueryChange = viewModel::onSearchQueryChange,
                    onSearch = { },
                    active = false,
                    onActiveChange = { },
                    placeholder = { Text(text = "Search your images") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search icon",
                            tint = Color.Black
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    content = {}
                )
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    content = {
                        items(value.photos) {
                            AsyncImage(
                                model = it.media,
                                contentScale = ContentScale.Crop,
                                contentDescription = it.description,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            )
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        is HomeViewModel.UiState.Loading -> {
            Text("Loading...")
        }
    }
}