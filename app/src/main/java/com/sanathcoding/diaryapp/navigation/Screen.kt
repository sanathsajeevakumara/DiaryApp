package com.sanathcoding.diaryapp.navigation

import com.sanathcoding.diaryapp.util.Constant.WRITE_SCREEN_ARGUMENT_KEY

sealed class Screen(val route: String) {
    object Authentication : Screen(route = "authentication_screen")
    object Home : Screen(route = "home_screen")
    object Write : Screen(route = "write_screen?$WRITE_SCREEN_ARGUMENT_KEY={diaryId}") {
        fun passDiaryId(diaryId: String) = "write_screen?$WRITE_SCREEN_ARGUMENT_KEY=$diaryId"
    }
}
