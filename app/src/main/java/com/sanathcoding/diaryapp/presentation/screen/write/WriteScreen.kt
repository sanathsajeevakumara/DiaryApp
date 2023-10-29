package com.sanathcoding.diaryapp.presentation.screen.write

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.presentation.screen.write.components.WriteTopAppBar

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WriteScreen(
    selectedDiary: Diary?,
    pagerState: PagerState,
    uiState: UiState,
    onBackPressed: () -> Unit,
    onDeleteConfirmClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            WriteTopAppBar(
                selectedDiary = selectedDiary,
                onBackPressed = onBackPressed,
                onDeleteConfirmClicked = onDeleteConfirmClicked
            )
        },
        content = {
            WriteContent(
                paddingValues = it,
                title = uiState.title,
                onTitleChanged = {},
                description = uiState.description,
                onDescriptionChanged = {},
                pagerState = pagerState
            )
        }
    )
}