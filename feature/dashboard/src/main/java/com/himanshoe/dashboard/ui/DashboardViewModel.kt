package com.himanshoe.dashboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.event.Event
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.dashboard.data.request.VaccineLocatorRequest
import com.himanshoe.dashboard.data.response.VaccineLocatorResponse
import com.himanshoe.dashboard.domain.GetVaccineLocationUseCase
import com.himanshoe.dashboard.util.deepLinkToSearchByPin
import com.himanshoe.dashboard.util.deepLinkToSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val getVaccineLocationUseCase: GetVaccineLocationUseCase,
    private val sessionManager: SessionManager
) : BaseViewModel(networkHelper) {

    val navigator = com.himanshoe.core.navigation.Navigator()

    private val _vaccineLocationResponse = MutableLiveData<VaccineLocatorResponse?>()
    val vaccineLocationResponse: LiveData<VaccineLocatorResponse?>
        get() = _vaccineLocationResponse

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String>
        get() = _searchQuery

    private val _dismissBanner = MutableLiveData(Event(false))
    val dismissBanner: LiveData<Event<Boolean>>
        get() = _dismissBanner

    fun init() {
        viewModelScope.launch {
            val request = VaccineLocatorRequest(
                sessionManager.getDistrictId().toString(),
                sessionManager.getCurrentDate()
            )
            getVaccineLocationUseCase.invoke(request)
                .catch {
                    catchError()
                }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> _vaccineLocationResponse.postValue(result.response)
                        is Status.OnFailed -> catchError()
                    }
                }
        }

    }

    private fun catchError() {
        _vaccineLocationResponse.postValue(null)
    }

    @FlowPreview
    fun onSearch(searchQuery: String) {
        viewModelScope.launch {
            flowOf(searchQuery)
                .debounce(300)
                .filter { query ->
                    return@filter query.isNotEmpty()
                }
                .distinctUntilChanged()
                .collect {
                    _searchQuery.postValue(it)
                }
        }
    }

    fun navigateToSettings() {
        navigator.navigate(deepLinkToSettings())
    }

    fun navigateToSearch() {
        navigator.navigate(deepLinkToSearchByPin())
    }

    fun dismissBanner() {
        viewModelScope.launch {
            sessionManager.dismissBanner()
            _dismissBanner.postValue(Event(true))
        }
    }

    fun savePinCode(pinCode: Int) {
        if (pinCode.toString().count() == 6) {
            viewModelScope.launch {
                sessionManager.dismissBanner()
                sessionManager.savePinCodeForDistrict(pinCode)
            }
        }
    }
}