package com.sanathcoding.diaryapp.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.sanathcoding.diaryapp.presentation.screen.home.components.home.HomeContent
import com.sanathcoding.diaryapp.presentation.screen.home.components.home.HomeTopBar
import com.sanathcoding.diaryapp.presentation.screen.home.components.navigation.HomeNavigationDrawer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    drawerState: DrawerState,
    onSignOutClicked: () -> Unit,
    onMenuClicked: () -> Unit,
    navigateToWrite: () -> Unit
) {
    HomeNavigationDrawer(
        drawerState = drawerState,
        onSignOutClicked = onSignOutClicked
    ) {
        Scaffold(
            topBar = {
                HomeTopBar(onMenuClicked = onMenuClicked)
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { navigateToWrite() }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "New/Edit Diary Icon"
                    )
                }
            },
            content = {
                HomeContent(diaryNotes = mapOf(), onClick = {})
            }
        )
    }
}