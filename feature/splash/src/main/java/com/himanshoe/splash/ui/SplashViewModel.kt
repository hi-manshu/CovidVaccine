package com.himanshoe.splash.ui

import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.splash.util.deepLinkToState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(networkHelper: NetworkHelper) :
    BaseViewModel(networkHelper) {

    val navigator = Navigator()

    fun init() {
        viewModelScope.launch {
            delay(2000)
            navigator.navigate(deepLinkToState())
        }
    }
}