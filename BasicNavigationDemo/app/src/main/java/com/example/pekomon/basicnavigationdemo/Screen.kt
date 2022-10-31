package com.example.pekomon.basicnavigationdemo

const val DETAIL_SCREEN_ARGUMENT_KEY_ID = "id"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/{$DETAIL_SCREEN_ARGUMENT_KEY_ID}") {
        fun passId(id: Int): String {
            return this.route.replace(
                oldValue = "{$DETAIL_SCREEN_ARGUMENT_KEY_ID}",
                newValue = id.toString()
            )
        }
    }
}
