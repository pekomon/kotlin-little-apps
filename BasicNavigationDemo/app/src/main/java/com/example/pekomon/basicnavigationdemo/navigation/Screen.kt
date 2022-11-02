package com.example.pekomon.basicnavigationdemo.navigation

const val DETAIL_SCREEN_ARGUMENT_KEY_ID = "id"
const val DETAIL_SCREEN_ARGUMENT_KEY_NAME = "name"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen?$DETAIL_SCREEN_ARGUMENT_KEY_ID={$DETAIL_SCREEN_ARGUMENT_KEY_ID}" +
            "&$DETAIL_SCREEN_ARGUMENT_KEY_NAME={$DETAIL_SCREEN_ARGUMENT_KEY_NAME}") {
        /*
        fun passId(id: Int = -1): String {
            return "detail_screen?$DETAIL_SCREEN_ARGUMENT_KEY_ID=$id"
        }
        */
        fun passIdAndName(
            id: Int = -1,
            name: String = "Unknown"
        ): String {
            return return "detail_screen?$DETAIL_SCREEN_ARGUMENT_KEY_ID=$id&$DETAIL_SCREEN_ARGUMENT_KEY_NAME=$name"
        }
    }
    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
}
