package com.example.pekomon.basicnavigationdemo

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_SCREEN_ARGUMENT_KEY_ID) {
                    type = NavType.IntType
                    defaultValue = -1
                    // Also possible to use nullable = true
                } /*,
                navArgument(DETAIL_SCREEN_ARGUMENT_KEY_NAME) {
                    type = NavType.StringType
                } */
            )
        ) {
            Log.d("Args id", it.arguments?.getInt(DETAIL_SCREEN_ARGUMENT_KEY_ID).toString())
            DetailScreen(navController = navController)
        }
    }
}