package com.example.pekomon.basicnavigationdemo.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pekomon.basicnavigationdemo.navigation.AUTH_ROUTE
import com.example.pekomon.basicnavigationdemo.navigation.Screen
import com.example.pekomon.basicnavigationdemo.screens.LoginScreen
import com.example.pekomon.basicnavigationdemo.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTH_ROUTE
    ) {
        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController = navController)
        }
    }
}