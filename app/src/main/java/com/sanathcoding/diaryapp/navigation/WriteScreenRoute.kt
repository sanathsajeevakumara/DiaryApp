package com.sanathcoding.diaryapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sanathcoding.diaryapp.util.Constant.WRITE_SCREEN_ARGUMENT_KEY

fun NavGraphBuilder.writeScreenRoute() {
    composable(route = Screen.Write.route, arguments = listOf(navArgument(name = WRITE_SCREEN_ARGUMENT_KEY){
        type = NavType.StringType
        nullable = true
        defaultValue = null
    })) {
        
    }
}