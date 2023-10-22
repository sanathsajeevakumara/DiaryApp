package com.sanathcoding.diaryapp.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.ui.theme.Elevation
import com.sanathcoding.diaryapp.util.toInstant

@Composable
fun DiaryHolder(diary: Diary, onClick: (String) -> Unit) {

    val localDensity = LocalDensity.current
    var componentHeight by remember { mutableStateOf(0.dp) }
    var isGalleryOpened by remember { mutableStateOf(false) }

    Row(modifier = Modifier.clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick(
            diary._id.toString()
        )
    }) {
        Spacer(modifier = Modifier.width(14.dp))
        Surface(
            modifier = Modifier
                .width(2.dp)
                .height(componentHeight + 14.dp),
            tonalElevation = Elevation.level1
        ) {}
        Spacer(modifier = Modifier.width(20.dp))
        Surface(
            modifier = Modifier
                .clip(shape = Shapes().medium)
                .onGloballyPositioned {
                    componentHeight = with(localDensity) { it.size.height.toDp() }
                }, tonalElevation = Elevation.level1
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                DiaryHeader(moodName = diary.mood, time = diary.date.toInstant())
                Text(
                    modifier = Modifier.padding(14.dp),
                    text = diary.description,
                    style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                if (diary.images.isNotEmpty()) {
                    ShowGalleryButton(
                        galleryOpened = isGalleryOpened,
                        onClick = { isGalleryOpened = !isGalleryOpened })
                }
                AnimatedVisibility(visible = isGalleryOpened) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Gallery(images = diary.images)
                    }
                }
            }
        }
    }

}