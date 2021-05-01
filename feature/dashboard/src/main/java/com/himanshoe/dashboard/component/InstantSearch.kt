package com.himanshoe.dashboard.component

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun InstantSearch(triggerSearch: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { triggerSearch() },
        text = {
            Text(
                text = "PinCode",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )
        },

        icon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }
    )
}