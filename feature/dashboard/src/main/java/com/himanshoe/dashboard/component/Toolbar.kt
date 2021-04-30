package com.himanshoe.dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.core.design.medium
import com.himanshoe.dashboard.R

@Composable
fun Toolbar(onSettingsClicked: () -> Unit) {
    TopAppBar(
        modifier = Modifier
            .height(60.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(medium)
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        onSettingsClicked()
                    },
                painter = painterResource(R.drawable.ic_settings),
                contentDescription = "Icon",
                alignment = Alignment.BottomStart
            )

            Text(
                text = "Dashboard",
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.6f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}