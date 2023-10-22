package com.sanathcoding.diaryapp.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun ShowGalleryButton(
    galleryOpened: Boolean, onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(
            text = if (galleryOpened) "Hide Gallery" else "Open galley",
            style = TextStyle(fontSize = MaterialTheme.typography.bodySmall.fontSize)
        )
    }
}