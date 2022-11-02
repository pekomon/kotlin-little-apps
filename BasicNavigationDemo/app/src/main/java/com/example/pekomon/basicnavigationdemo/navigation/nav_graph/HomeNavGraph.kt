package com.example.pekomon.basicnavigationdemo.navigation.nav_graph

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.pekomon.basicnavigationdemo.navigation.DETAIL_SCREEN_ARGUMENT_KEY_ID
import com.example.pekomon.basicnavigationdemo.navigation.DETAIL_SCREEN_ARGUMENT_KEY_NAME
import com.example.pekomon.basicnavigationdemo.navigation.HOME_ROUTE
import com.example.pekomon.basicnavigationdemo.navigation.Screen
import com.example.pekomon.basicnavigationdemo.screens.DetailScreen
import com.example.pekomon.basicnavigationdemo.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
   navigation(
       startDestination = Screen.Home.route,
       route = HOME_ROUTE
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
   }
}