package com.himanshoe.settings.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.NavigateTo
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.navigation.event.Event
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.settings.util.deepLinkToState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    private val _districtPinCode = MutableLiveData<String>()
    val districtPinCode: LiveData<String>
        get() = _districtPinCode

    private val _dismissBanner = MutableLiveData(Event(false))
    val dismissBanner: LiveData<Event<Boolean>>
        get() = _dismissBanner

    fun init() {
        viewModelScope.launch {
            val location = sessionManager.getDistrictName() + ", " + sessionManager.getStateName()
            val districtPinCode = sessionManager.getPinCodeForDistrict()
            _location.postValue(location)
            _districtPinCode.postValue(districtPinCode)
        }
    }

    fun gotoStates() {
        navigator.navigate(deepLinkToState())
    }

    fun goBack() {
        navigator.navigate(NavigateTo.Back)
    }

    fun showPinCode() {
        _dismissBanner.postValue(Event(false))
    }

    fun dismissBanner() {
        viewModelScope.launch {
            sessionManager.dismissBanner()
            _dismissBanner.postValue(Event(true))
        }
    }

    fun savePinCode(pinCode: String) {
        if (pinCode.count() == 6) {
            viewModelScope.launch {
                sessionManager.dismissBanner()
                _dismissBanner.postValue(Event(true))
                sessionManager.savePinCodeForDistrict(pinCode)
                delay(1000)
            }
        } else {
            _error.postValue(Event("Please enter a correct pin code"))
        }
    }
}