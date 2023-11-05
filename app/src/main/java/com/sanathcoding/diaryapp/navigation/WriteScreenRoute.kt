package com.sanathcoding.diaryapp.navigation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sanathcoding.diaryapp.model.Mood
import com.sanathcoding.diaryapp.presentation.screen.write.WriteScreen
import com.sanathcoding.diaryapp.presentation.screen.write.WriteViewModel
import com.sanathcoding.diaryapp.util.Constant.WRITE_SCREEN_ARGUMENT_KEY

@OptIn(ExperimentalFoundationApi::class)
fun NavGraphBuilder.writeScreenRoute(onBackPressed: () -> Unit) {
    composable(
        route = Screen.Write.route,
        arguments = listOf(navArgument(name = WRITE_SCREEN_ARGUMENT_KEY) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        val viewModel: WriteViewModel = viewModel()
        val uiState = viewModel.uiState
        val pagerState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ) {
            Mood.values().size
        }

        LaunchedEffect(key1 = true) {
            Log.i("KeyId", "${uiState.selectedDiaryId}")
        }

        WriteScreen(
            selectedDiary = null,
            pagerState = pagerState,
            uiState = uiState,
            onTitleChanged = { viewModel.setTitle(title = uiState.title) },
            onDescriptionChanged = { viewModel.setDescription(description = uiState.description) },
            onBackPressed = onBackPressed,
            onDeleteConfirmClicked = {}
        )
    }
}