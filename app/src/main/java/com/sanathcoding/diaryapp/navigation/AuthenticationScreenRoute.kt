package com.sanathcoding.diaryapp.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sanathcoding.diaryapp.presentation.screen.auth.AuthenticationScreen
import com.sanathcoding.diaryapp.presentation.screen.auth.AuthenticationViewModel
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState

fun NavGraphBuilder.authenticationScreenRoute(
    navigateToHome: () -> Unit
) {
    composable(route = Screen.Authentication.route) {

        val authViewModel: AuthenticationViewModel = viewModel()
        val loadingState by authViewModel.loadingState
        val authenticated by authViewModel.authenticated
        val oneTapState = rememberOneTapSignInState()
        val messageBarState = rememberMessageBarState()

        AuthenticationScreen(
            loadingState = loadingState,
            oneTapState = oneTapState,
            messageBarState = messageBarState,
            authenticated = authenticated,
            onButtonClicked = {
                oneTapState.open()
                authViewModel.updateLoading(true)
            },
            onTokenIdReceived = { tokenId ->
                authViewModel.signInWithMongoAtlas(
                    tokenId = tokenId,
                    authResult = { result ->
                        authViewModel.updateLoading(false)
                        if (result) messageBarState.addSuccess("Successfully Authenticated!")
                    },
                    onError = { message ->
                        authViewModel.updateLoading(false)
                        messageBarState.addError(message)
                    }
                )
            },
            onDialogDismissed = { message ->
                authViewModel.updateLoading(false)
                messageBarState.addError(Exception(message))
            },
            navigateToHome = navigateToHome
        )
    }
}