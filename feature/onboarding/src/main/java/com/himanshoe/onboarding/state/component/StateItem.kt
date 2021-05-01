package com.himanshoe.onboarding.state.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.onboarding.state.data.response.State

@Composable
fun StateItem(state: State, onClick: (Int,String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable { onClick(state.stateId, state.stateName) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = state.stateName,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .height(30.dp)
                .padding(top = 2.dp),
            textAlign = TextAlign.Justify.apply {
                TextAlign.Center
            },
            style = MaterialTheme.typography.h4,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Icon(
            imageVector = Icons.Default.ArrowForward, 
            contentDescription = "click state",
            modifier = Modifier.padding(8.dp)
        )
    }

}