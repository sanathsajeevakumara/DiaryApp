package com.sanathcoding.diaryapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sanathcoding.diaryapp.presentation.screen.home.HomeScreen

fun NavGraphBuilder.homeScreenRoute(
    navigateToWrite: () -> Unit
) {
    composable(route = Screen.Home.route) {
        HomeScreen(
            onMenuClicked = {},
            navigateToWrite = navigateToWrite
        )
    }
}