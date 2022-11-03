package com.example.pekomon.bottombarnavdemo

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
    
}

@Composable
fun BottomBar(
    navHostController: NavHostController
) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar() {

        screens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    val gg = NavigationBarItemDefaults.colors().iconColor(selected = false).value.copy(alpha = 0.38f)
    NavigationBarItem(
        label = {
                Text(text = screen.title)
        },
        icon = {
               Icon(
                   imageVector = screen.icon,
                   contentDescription = "Bottom nav item"
               )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = NavigationBarItemDefaults.colors().iconColor(selected = false).value.copy(alpha = 0.38f),
            unselectedTextColor = NavigationBarItemDefaults.colors().textColor(selected = false).value.copy(alpha = 0.38f),
        ),
        onClick = {
            navHostController.navigate(screen.route)
        }
    )
}