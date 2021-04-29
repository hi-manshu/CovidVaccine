package com.himanshoe.splash.ui

import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.util.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(networkHelper: NetworkHelper) :
    BaseViewModel(networkHelper) {


}