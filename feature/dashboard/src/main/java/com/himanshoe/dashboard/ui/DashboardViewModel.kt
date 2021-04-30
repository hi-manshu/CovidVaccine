package com.himanshoe.dashboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.dashboard.data.request.VaccineLocatorRequest
import com.himanshoe.dashboard.data.response.VaccineLocatorResponse
import com.himanshoe.dashboard.domain.GetVaccineLocationUseCase
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

    private val _vaccineLocationResponse = MutableLiveData<VaccineLocatorResponse?>()
    val vaccineLocationResponse: LiveData<VaccineLocatorResponse?>
        get() = _vaccineLocationResponse

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String>
        get() = _searchQuery

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
}