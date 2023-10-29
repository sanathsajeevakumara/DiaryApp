package com.sanathcoding.diaryapp.presentation.screen.write

import com.sanathcoding.diaryapp.model.Mood

data class UiState(
    val selectedDiaryId: String? = null,
    val title: String = "",
    val description: String = "",
    val mood: Mood = Mood.Neutral,
)
