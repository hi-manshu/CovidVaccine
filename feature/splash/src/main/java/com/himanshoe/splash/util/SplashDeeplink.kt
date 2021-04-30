package com.himanshoe.splash.util

import androidx.navigation.navOptions
import com.himanshoe.core.navigation.NavigateTo
import com.roomiapp.core.navigator.fadeAnimation

private fun navigateToDashboard(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://dashboard",
        navOptions {
            fadeAnimation()
        }
    )
}

fun deepLinkToDashboard() = navigateToDashboard()