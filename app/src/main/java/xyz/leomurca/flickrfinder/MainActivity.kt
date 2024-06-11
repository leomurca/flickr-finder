package xyz.leomurca.flickrfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import xyz.leomurca.flickrfinder.navigation.HOME_ROUTE
import xyz.leomurca.flickrfinder.navigation.detailsScreen
import xyz.leomurca.flickrfinder.navigation.homeScreen
import xyz.leomurca.flickrfinder.navigation.navigateToDetails
import xyz.leomurca.flickrfinder.ui.details.DetailsViewModel
import xyz.leomurca.flickrfinder.ui.theme.FlickrFinderTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlickrFinderTheme {
                DetailsViewModelProvider {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = HOME_ROUTE) {
                        homeScreen { navController.navigateToDetails() }
                        detailsScreen()
                    }
                }
            }
        }
    }
}

private val LocalDetailsViewModel = compositionLocalOf<DetailsViewModel> {
    error("DetailsViewModel not provided")
}

@Composable
private fun DetailsViewModelProvider(
    content: @Composable () -> Unit
) {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    CompositionLocalProvider(LocalDetailsViewModel provides detailsViewModel) {
        content()
    }
}