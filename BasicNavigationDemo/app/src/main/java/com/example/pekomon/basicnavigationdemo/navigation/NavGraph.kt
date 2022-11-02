package com.example.pekomon.basicnavigationdemo

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pekomon.basicnavigationdemo.navigation.DETAIL_SCREEN_ARGUMENT_KEY_ID
import com.example.pekomon.basicnavigationdemo.navigation.DETAIL_SCREEN_ARGUMENT_KEY_NAME
import com.example.pekomon.basicnavigationdemo.navigation.Screen
import com.example.pekomon.basicnavigationdemo.screens.DetailScreen
import com.example.pekomon.basicnavigationdemo.screens.HomeScreen
import com.example.pekomon.basicnavigationdemo.screens.LoginScreen
import com.example.pekomon.basicnavigationdemo.screens.SignUpScreen

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
                } ,
                navArgument(DETAIL_SCREEN_ARGUMENT_KEY_NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("Args id", it.arguments?.getInt(DETAIL_SCREEN_ARGUMENT_KEY_ID).toString())
            Log.d("Args name", it.arguments?.getString(DETAIL_SCREEN_ARGUMENT_KEY_NAME).toString())
            DetailScreen(navController = navController)
        }
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