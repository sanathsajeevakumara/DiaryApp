package com.sanathcoding.diaryapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sanathcoding.diaryapp.presentation.screen.auth.AuthenticationScreen
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState

fun NavGraphBuilder.authenticationScreenRoute() {
    composable(route = Screen.Authentication.route) {

        val oneTapState = rememberOneTapSignInState()
        val messageBarState = rememberMessageBarState()

        AuthenticationScreen(
            loadingState = oneTapState.opened,
            oneTapState = oneTapState,
            messageBarState = messageBarState,
            onButtonClicked = {
                oneTapState.open()
            }
        )
    }
}