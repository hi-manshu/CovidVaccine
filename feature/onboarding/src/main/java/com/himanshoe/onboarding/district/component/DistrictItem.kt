package com.himanshoe.onboarding.district.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.onboarding.district.data.response.District

@Composable
fun DistrictItem(district: District, onClick: (Int) -> Unit) {
    Text(
        text = district.districtName,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(30.dp)
            .padding(top = 2.dp)
            .clickable { onClick(district.districtId) },
        textAlign = TextAlign.Justify.apply {
            TextAlign.Center
        },
        style = MaterialTheme.typography.h4,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold
    )
}