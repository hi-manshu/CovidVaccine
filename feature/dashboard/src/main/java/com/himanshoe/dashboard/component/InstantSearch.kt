package com.himanshoe.dashboard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
    ExtendedFloatingActionButton(
        onClick = { triggerSearch() },
        text = {
            Text(
                text = "PinCode",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
        ) },

        icon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }
    )
}