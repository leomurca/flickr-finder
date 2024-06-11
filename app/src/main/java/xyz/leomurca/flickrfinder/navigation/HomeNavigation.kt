package xyz.leomurca.flickrfinder.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import xyz.leomurca.flickrfinder.LocalDetailsViewModel
import xyz.leomurca.flickrfinder.ui.home.HomeScreen

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(onTapPhoto: () -> Unit) {
    composable(
        route = HOME_ROUTE,
    ) {
        HomeScreen(onTapPhoto = onTapPhoto, detailsViewModel = LocalDetailsViewModel.current)
    }
}
