package com.himanshoe.dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshoe.dashboard.data.response.Center

@Composable
fun LocationItem(center: Center) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AddressItem(center)
            TimingItem(center)
            AgeAndSlots(center)
        }
    }
}

@Composable
private fun AgeAndSlots(center: Center) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Minimum Age",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )

        Spacer(Modifier.height(1.dp))
        if (center.sessions.isNotEmpty()) {
            Text(
                text = center.sessions[0].minAgeLimit.toString() + " yrs",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body2,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(20.dp))
            LazyRow {
                items(items = center.sessions[0].slots ?: emptyList(), key = null, {
                    BuildChip(label = it)
                })
            }
        }
    }
}

@Composable
private fun AddressItem(center: Center) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
    ) {
        Text(
            text = center.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(1.dp))

        Text(
            text = """${center.blockName} - ${center.districtName}""",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.White
        )

        Spacer(Modifier.height(1.dp))

        Text(
            text = """${center.stateName} - ${center.pincode}""",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.White
        )
    }
}

@Composable
private fun TimingItem(center: Center) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Timing",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )

        Spacer(Modifier.height(1.dp))

        Text(
            text = """${center.from.take(5)} - ${center.to.take(5)}""",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(20.dp))

    }
}

@Composable
private fun BuildChip(label: String) {
    Box(modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
        Surface(
            elevation = 4.dp,
            shape = CircleShape,
            color = MaterialTheme.colors.onPrimary,
        ) {
            Text(
                label,
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
                style = MaterialTheme.typography.button.copy(color = Color.White),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun DummyPreview() {
    val center = Center(name = "Gouranga TE", blockName = "Himanshu")
    LocationItem(center = center)
}
