package com.himanshoe.splash.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.himanshoe.core.R
import com.himanshoe.core.design.larger

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
        }
    )
}
