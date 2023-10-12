package com.sanathcoding.diaryapp.presentation.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sanathcoding.diaryapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(onSignOutClicked: () -> Unit) {
    ModalDrawerSheet(
        content = {
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .align(CenterHorizontally),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo"
            )
            NavigationDrawerItem(
                label = {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.google_logo),
                            contentDescription = "Google Logo"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Sign Out")
                    }
                },
                selected = false,
                onClick = onSignOutClicked
            )
        }
    )
}