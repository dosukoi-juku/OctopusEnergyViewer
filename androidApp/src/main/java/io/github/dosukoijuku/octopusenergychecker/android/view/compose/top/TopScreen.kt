package io.github.dosukoijuku.octopusenergychecker.android.view.compose.top

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.dosukoijuku.octopusenergychecker.android.R
import io.github.dosukoijuku.octopusenergychecker.android.view.compose.home.HomeScreen
import io.github.dosukoijuku.octopusenergychecker.android.view.theme.OctopusTheme

private sealed class TopScreenRoute(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    data object Home : TopScreenRoute(
        route = "home",
        title = R.string.nav_home_title,
        icon = Icons.Filled.Home
    )

    data object Settings : TopScreenRoute(
        route = "setting",
        title = R.string.nav_home_title,
        icon = Icons.Filled.Settings
    )
}

@Composable
fun TopScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            TopScreenBottomNavigation(
                onNavItemSelect = {
                    navController.navigate(it.route) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                currentRoute = currentRoute
            )
        }
    ) {
        TopScreenNavHost(
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
private fun TopScreenNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopScreenRoute.Home.route,
    ) {
        composable(TopScreenRoute.Home.route) {
            HomeScreen()
        }
        composable(TopScreenRoute.Settings.route) {
            HomeScreen()
        }
    }
}

@Composable
private fun TopScreenBottomNavigation(
    currentRoute: String?,
    onNavItemSelect: (TopScreenRoute) -> Unit,
    modifier: Modifier = Modifier
) {
    val navItems = listOf(
        TopScreenRoute.Home,
        TopScreenRoute.Settings
    )


    BottomNavigation(
        modifier = modifier
    ) {
        navItems.forEach { navItem ->
            val title = stringResource(id = navItem.title)
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = { onNavItemSelect.invoke(navItem) },
                icon = { Icon(imageVector = navItem.icon, contentDescription = title) },
                label = { Text(text = title) }
            )
        }
    }
}

@Preview
@Composable
private fun TopScreenPreview() {
    OctopusTheme {
        TopScreen()
    }
}