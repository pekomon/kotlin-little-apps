package com.example.pekomon.bottombarnavdemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pekomon.bottombarnavdemo.screens.HomeScreen
import com.example.pekomon.bottombarnavdemo.screens.ProfileScreen
import com.example.pekomon.bottombarnavdemo.screens.SettingsScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ) {
            HomeScreen()
        }
        composable(
            route = BottomBarScreen.Profile.route
        ) {
            ProfileScreen()
        }
        composable(
            route = BottomBarScreen.Settings.route
        ) {
            SettingsScreen()
        }
    }
}