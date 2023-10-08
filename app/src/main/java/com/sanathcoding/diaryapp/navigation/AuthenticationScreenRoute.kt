package com.sanathcoding.diaryapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sanathcoding.diaryapp.presentation.screen.auth.AuthenticationScreen

fun NavGraphBuilder.authenticationScreenRoute() {
    composable(route = Screen.Authentication.route) {
        AuthenticationScreen(
            loadingState = false,
            onButtonClicked = {}
        )
    }
}