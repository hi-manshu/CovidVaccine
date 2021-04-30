package com.himanshoe.splash.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.himanshoe.core.R
import com.himanshoe.core.design.larger
import com.himanshoe.core.design.medium

@Composable
fun SplashComponent() {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Image(
                    modifier = Modifier
                        .padding(larger)
                        .fillMaxWidth(fraction = 0.8F),
                    painter = painterResource(R.drawable.ic_icon),
                    contentDescription = "Icon"
                )
            }
        },
        bottomBar = {
            Text(
                text = "Build by Himanshu Singh",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(medium),
                textAlign = TextAlign.Center,
            )
        }
    )
}