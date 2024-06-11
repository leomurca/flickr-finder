package xyz.leomurca.flickrfinder.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import xyz.leomurca.flickrfinder.ui.details.DetailsScreen


const val DETAILS_ROUTE = "details"

fun NavController.navigateToDetails() = navigate(DETAILS_ROUTE)

fun NavGraphBuilder.detailsScreen() {
    composable(
        route = DETAILS_ROUTE,
    ) {
        DetailsScreen()
    }
}
