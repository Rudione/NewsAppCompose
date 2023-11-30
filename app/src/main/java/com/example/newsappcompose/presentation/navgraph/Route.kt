package com.example.newsappcompose.presentation.navgraph


/**
 * @property [Route] class for route. It is sealed class. It is used for navigation.
 * It is used in [NavGraph].
 * @property route
 */
sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route("onBoardingScreen")
    object HomeScreen : Route("homeScreen")
    object SearchScreen : Route("searchScreen")
    object BookmarksScreen : Route("bookmarksScreen")
    object DetailsScreen : Route("detailsScreen")
    object AppStartNavigation : Route("appStartNavigation")
    object NewsNavigation : Route("newsNavigation")
    object NewsNavigatorScreen : Route("newsNavigatorScreen")
}
