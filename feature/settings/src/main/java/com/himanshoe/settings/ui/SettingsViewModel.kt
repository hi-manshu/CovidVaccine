package com.himanshoe.settings.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.settings.util.deepLinkToState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val sessionManager: SessionManager
) :
    BaseViewModel(networkHelper) {

    val navigator = Navigator()

    private val _location = MutableLiveData<String?>()
    val location: LiveData<String?>
        get() = _location

    fun init() {
        viewModelScope.launch {
            val location = sessionManager.getDistrictName() + ", " + sessionManager.getStateName()
            _location.postValue(location)
        }
    }

    fun gotoStates() {
        navigator.navigate(deepLinkToState())
    }
}