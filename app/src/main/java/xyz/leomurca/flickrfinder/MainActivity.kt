package xyz.leomurca.flickrfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import xyz.leomurca.flickrfinder.ui.home.HomeScreen
import xyz.leomurca.flickrfinder.ui.home.HomeViewModel
import xyz.leomurca.flickrfinder.ui.theme.FlickrFinderTheme

class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlickrFinderTheme {
                HomeScreen(viewModel)
            }
        }
    }
}