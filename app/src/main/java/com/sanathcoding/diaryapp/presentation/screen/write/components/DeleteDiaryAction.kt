package com.sanathcoding.diaryapp.presentation.screen.write.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.sanathcoding.diaryapp.R
import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.presentation.components.DisplayAlertDialog

@Composable
fun DeleteDiaryAction(
    selectedDiary: Diary?,
    onDeleteConfirmClicked: () -> Unit
) {
    var extended by remember {
        mutableStateOf(false)
    }
    var openDialog by remember {
        mutableStateOf(false)
    }
    DropdownMenu(
        expanded = extended,
        onDismissRequest = { extended = false }
    ) {
        DropdownMenuItem(
            text = { Text(text = "Delete") },
            onClick = {
                openDialog = true
                extended = false
            },
        )
    }

    DisplayAlertDialog(
        title = "Delete",
        message = "${stringResource(R.string.are_you_sure)} ${selectedDiary?.title}?",
        dialogOpened = openDialog,
        onDialogClosed = { openDialog = false },
        onYesClicked = onDeleteConfirmClicked
    )
    IconButton(onClick = { extended = !extended }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Over flow menu icon",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}