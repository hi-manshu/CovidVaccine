package com.himanshoe.splash.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.himanshoe.core.R
import com.himanshoe.core.design.BaseTheme
import com.himanshoe.splash.ui.SplashViewModel

@Composable
fun SplashComponent() {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BaseTheme.colors.background)
                    .wrapContentSize(Alignment.Center)
            ) {
                Image(
                    modifier = Modifier
                        .padding(BaseTheme.sizes.larger)
                        .fillMaxWidth(fraction = 0.8F),
                    painter = painterResource(R.drawable.ic_icon),
                    contentDescription = "Icon"
                )
            }
        },
        bottomBar = {
            Text(
                text = "Build by <3",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = BaseTheme.sizes.medium),
                textAlign = TextAlign.Center,
                style = BaseTheme.typography.label
            )
        }
    )
}