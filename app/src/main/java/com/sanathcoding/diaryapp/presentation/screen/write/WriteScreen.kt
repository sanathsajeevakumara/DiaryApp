package com.sanathcoding.diaryapp.presentation.screen.write

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.presentation.screen.write.components.WriteTopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WriteScreen(
    selectedDiary: Diary?,
    onBackPressed: () -> Unit,
    onDeleteConfirmClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            WriteTopAppBar(
                selectedDiary = selectedDiary,
                onBackPressed = onBackPressed,
                onDeleteConfirmClicked = onDeleteConfirmClicked
            )
        },
        content = {}
    )
}