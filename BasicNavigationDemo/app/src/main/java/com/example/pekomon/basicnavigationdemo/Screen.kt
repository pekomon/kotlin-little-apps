package com.example.pekomon.basicnavigationdemo

const val DETAIL_SCREEN_ARGUMENT_KEY_ID = "id"
const val DETAIL_SCREEN_ARGUMENT_KEY_NAME = "name"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/{$DETAIL_SCREEN_ARGUMENT_KEY_ID}/{$DETAIL_SCREEN_ARGUMENT_KEY_NAME}") {
        /*
        fun passId(id: Int): String {
            return this.route.replace(
                oldValue = "{$DETAIL_SCREEN_ARGUMENT_KEY_ID}",
                newValue = id.toString()
            )
        }
        */
        fun passIdAndName(
            id: Int,
            name: String
        ): String {
            return "detail_screen/$id/$name"
        }
    }
}
