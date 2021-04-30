package com.himanshoe.dashboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.dashboard.data.request.VaccineLocatorRequest
import com.himanshoe.dashboard.data.response.VaccineLocatorResponse
import com.himanshoe.dashboard.domain.GetVaccineLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val getVaccineLocationUseCase: GetVaccineLocationUseCase
) : BaseViewModel(networkHelper) {

    private val _vaccineLocationResponse = MutableLiveData<VaccineLocatorResponse?>()
    val vaccineLocationResponse: LiveData<VaccineLocatorResponse?>
        get() = _vaccineLocationResponse

    fun init() {
        viewModelScope.launch {
            getVaccineLocationUseCase.invoke(VaccineLocatorRequest("53", "31-03-2021"))
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
}