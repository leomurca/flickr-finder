package xyz.leomurca.flickrfinder.ui.details

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import xyz.leomurca.flickrfinder.LocalDetailsViewModel


@Composable
fun DetailsScreen(viewModel: DetailsViewModel = LocalDetailsViewModel.current) {
    val uiState = viewModel.uiState.collectAsState()

    uiState.value?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(8.dp),
        ) {
            AsyncImage(
                model = it.media,
                contentScale = ContentScale.Fit,
                contentDescription = it.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeightIn(min = 100.dp, max = 300.dp)
                    .background(Color.Black)
            )

            Text(text = it.title)
            Text(text = "Uploaded on: ${it.published}")
            Text(text = "Taken on: ${it.dateTaken}")
            Text(text = "Author: ${it.author}")
            HtmlText(html = it.description)
        }
    }
}

@Composable
private fun HtmlText(html: String) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            webViewClient = WebViewClient()
            loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
        }
    })
}