package xyz.leomurca.flickrfinder.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import xyz.leomurca.flickrfinder.ui.extensions.shimmerEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState = viewModel.uiState.collectAsState()
    val searchQuery = viewModel.searchQuery.collectAsState()

    Scaffold(
        topBar = {
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
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (val value = uiState.value) {
                is HomeViewModel.UiState.Loaded.Success.PopulatedState -> {
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

                is HomeViewModel.UiState.Loaded.Success.EmptyState -> EmptyStatePlaceholder()

                is HomeViewModel.UiState.Loaded.Error -> {
                    Text(text = value.message)
                }

                is HomeViewModel.UiState.Loading -> {
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(2),
                        verticalItemSpacing = 4.dp,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            items(10) {
                                LoadingPlaceholder(it)
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
private fun LoadingPlaceholder(index: Int) {
    val isEven = index % 2==0
    Row(Modifier.padding(top = 10.dp)) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(if (isEven) 200.dp else 300.dp)
                .shimmerEffect()
        )
    }
}

@Composable
private fun EmptyStatePlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No photos available",
            fontSize = 20.sp,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
