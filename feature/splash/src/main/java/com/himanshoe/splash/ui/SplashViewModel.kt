package com.himanshoe.splash.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.util.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(networkHelper: NetworkHelper) :
    BaseViewModel(networkHelper) {

    private val _navigateToDashboard = MutableLiveData<Boolean>()
    val navigateToDashboard: LiveData<Boolean>
        get() = _navigateToDashboard

    val navigator = Navigator()

    fun init() {
        viewModelScope.launch {
            delay(2000)
            _navigateToDashboard.postValue(true)
        }
    }
}