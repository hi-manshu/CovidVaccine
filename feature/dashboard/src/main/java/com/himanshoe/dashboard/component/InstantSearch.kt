package com.himanshoe.dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.himanshoe.core.navigation.event.consume
import com.himanshoe.dashboard.ui.DashboardViewModel

@Composable
fun InstantSearch( triggerSearch: () -> Unit) {

    OutlinedButton(
        onClick = { triggerSearch() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(
                Alignment.Center
            )
            .padding(16.dp)
            .clip(CircleShape)

    ) {
        Text(
            text = "Search by Pin Code",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
        )
    }
}