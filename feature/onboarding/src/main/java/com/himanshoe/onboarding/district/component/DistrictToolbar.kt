package com.himanshoe.onboarding.district.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.core.design.medium

@Composable
fun DistrictToolbar() {
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
            Text(
                text = "Select Current District",
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