package com.himanshoe.dashboard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.core.design.medium

@Composable
fun Toolbar() {
    TopAppBar(
        modifier = Modifier
            .height(60.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Text(
            text = "Dashboard",
            modifier = Modifier
                .fillMaxWidth()
                .padding(medium),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3
        )
    }
}