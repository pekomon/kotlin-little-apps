package com.example.pekomon.basicnavigationdemo.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.pekomon.basicnavigationdemo.navigation.*

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
    ) {
        // Nested navigation
        homeNavGraph(navController)
        authNavGraph(navController)
    }
}