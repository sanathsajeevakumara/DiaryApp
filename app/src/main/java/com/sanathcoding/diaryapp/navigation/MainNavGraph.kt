package com.sanathcoding.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainNavGraph(
    startDestination: String,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authenticationScreenRoute(
            navigateToHome = {
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            }
        )
        homeScreenRoute(
            navigateToWrite = {
                navController.navigate(Screen.Write.route)
            }
        )
        writeScreenRoute()
    }
}