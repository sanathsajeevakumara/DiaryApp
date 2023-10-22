package com.sanathcoding.diaryapp.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sanathcoding.diaryapp.presentation.screen.home.HomeScreen
import com.sanathcoding.diaryapp.presentation.screen.home.HomeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.homeScreenRoute(
    navigateToWrite: () -> Unit
) {
    composable(route = Screen.Home.route) {
        val homeViewModel: HomeViewModel = viewModel()
        val diaries by homeViewModel.diaries
        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        HomeScreen(
            diaries = diaries,
            drawerState = drawerState,
            onSignOutClicked = {},
            onMenuClicked = {
                scope.launch {
                    drawerState.open()
                }
            },
            navigateToWrite = navigateToWrite
        )
    }
}