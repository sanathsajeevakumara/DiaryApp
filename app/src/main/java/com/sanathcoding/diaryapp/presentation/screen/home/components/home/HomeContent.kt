package com.sanathcoding.diaryapp.presentation.screen.home.components.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.presentation.components.DiaryHolder
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    paddingValues: PaddingValues,
    diaryNotes: Map<LocalDate, List<Diary>>,
    onClick: (String) -> Unit
) {
    if (diaryNotes.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = paddingValues.calculateTopPadding())
                .padding(bottom = paddingValues.calculateBottomPadding())
                .padding(start = paddingValues.calculateStartPadding(LayoutDirection.Ltr))
                .padding(bottom = paddingValues.calculateEndPadding(LayoutDirection.Ltr))
        ) {
            diaryNotes.forEach { (localDate, diaries) ->
                stickyHeader(key = localDate) {
                    DateHeader(localDate = localDate)
                }
                items(
                    items = diaries,
                    key = { it._id.toString() }
                ) {
                    DiaryHolder(diary = it, onClick = onClick)
                }
            }
        }
    } else EmptyPage()
}