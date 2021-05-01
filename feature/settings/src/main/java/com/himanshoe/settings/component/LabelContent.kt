package com.himanshoe.settings.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.settings.ui.SettingsViewModel

@Composable
fun LabelContent(settingsViewModel: SettingsViewModel, onLocationClick: () -> Unit) {
    val locationState = settingsViewModel.location.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        LocationItem(locationState,onLocationClick)
        DeveloperItem()
    }
}

@Composable
private fun LocationItem(locationState: State<String?>, onLocationClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onLocationClick()
            }

    ) {
        Text(
            text = "Location",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(1.dp))

        Text(
            text = locationState.value ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Divider(Modifier.height(1.dp))

    }
}

@Composable
private fun DeveloperItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = "Contributors",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(1.dp))

        Text(
            text = "Himanshu Singh (Twitter: @hi_man_shoe)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(10.dp))

        Text(
            text = "Rohan Shah (LinkedIn: @rohanrshah)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Divider(Modifier.height(1.dp))

    }
}
