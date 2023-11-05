package com.sanathcoding.diaryapp.presentation.screen.write

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.model.Mood
import com.sanathcoding.diaryapp.presentation.screen.write.components.WriteTopAppBar

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WriteScreen(
    pagerState: PagerState,
    uiState: UiState,
    moodName: () -> String,
    onTitleChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    onDeleteConfirmClicked: () -> Unit,
) {
    LaunchedEffect(key1 = uiState.mood) {
        pagerState.scrollToPage(Mood.valueOf(uiState.mood.name).ordinal)
    }
    Scaffold(
        topBar = {
            WriteTopAppBar(
                selectedDiary = uiState.selectedDiary,
                moodName = moodName,
                onBackPressed = onBackPressed,
                onDeleteConfirmClicked = onDeleteConfirmClicked
            )
        },
        content = {
            WriteContent(
                paddingValues = it,
                title = uiState.title,
                onTitleChanged = onTitleChanged,
                description = uiState.description,
//                buttonColor = uiState.mood.containerColor,
//                buttonTextColor = uiState.mood.contentColor,
                onDescriptionChanged = onDescriptionChanged,
                pagerState = pagerState
            )
        }
    )
}