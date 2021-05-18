package com.himanshoe.login.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.core.design.medium

@Composable
fun LoginToolbar(onCancel: () -> Unit) {
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
            Icon(
                imageVector = Icons.Sharp.Close,
                tint = colorResource(id = androidx.compose.material.R.color.androidx_core_secondary_text_default_material_light),
                contentDescription = "cancel",
                modifier = Modifier.clickable { onCancel() }
            )
            Text(
                text = "Login",
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