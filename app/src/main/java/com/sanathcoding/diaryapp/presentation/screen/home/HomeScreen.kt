package com.sanathcoding.diaryapp.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.LayoutDirection
import com.sanathcoding.diaryapp.data.repository.Diaries
import com.sanathcoding.diaryapp.presentation.screen.home.components.home.EmptyPage
import com.sanathcoding.diaryapp.presentation.screen.home.components.home.HomeContent
import com.sanathcoding.diaryapp.presentation.screen.home.components.home.HomeTopBar
import com.sanathcoding.diaryapp.presentation.screen.home.components.navigation.HomeNavigationDrawer
import com.sanathcoding.diaryapp.util.RequestState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    diaries: Diaries,
    drawerState: DrawerState,
    onSignOutClicked: () -> Unit,
    onMenuClicked: () -> Unit,
    navigateToWrite: () -> Unit
) {
    var padding by remember { mutableStateOf(PaddingValues()) }
    HomeNavigationDrawer(
        drawerState = drawerState,
        onSignOutClicked = onSignOutClicked
    ) {
        Scaffold(
            topBar = {
                HomeTopBar(onMenuClicked = onMenuClicked)
            },
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.padding(end = padding.calculateEndPadding(LayoutDirection.Ltr)),
                    onClick = { navigateToWrite() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "New/Edit Diary Icon"
                    )
                }
            },
            content = {
                padding = it
                when (diaries) {
                    is RequestState.Success -> {
                        HomeContent(paddingValues = it, diaryNotes = diaries.data, onClick = {})
                    }

                    is RequestState.Error -> {
                        EmptyPage(
                            title = "Error",
                            subTitle = "${diaries.error.message}"
                        )
                    }

                    is RequestState.Loading -> Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }

                    else -> {}
                }
            }
        )
    }
}