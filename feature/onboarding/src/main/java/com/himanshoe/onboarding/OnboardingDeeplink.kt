package com.himanshoe.onboarding

import androidx.navigation.navOptions
import com.himanshoe.core.navigation.NavigateTo
import com.himanshoe.core.navigation.fadeAnimation

private fun navigateToDistrict(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://district",
    )
}

fun deeplinkToDistrict() = navigateToDistrict()

private fun navigateToDashboard(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://dashboard",
        navOptions {
            popUpTo(R.id.districtFragment) { inclusive = true }
            fadeAnimation()
        }
    )
}

fun deepLinkToDashboard() = navigateToDashboard()