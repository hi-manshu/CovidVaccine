package com.himanshoe.dashboard.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.dashboard.data.request.VaccineLocatorRequest
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

    fun init() {
        viewModelScope.launch {
            getVaccineLocationUseCase.invoke(VaccineLocatorRequest("53", "31-03-2021"))
                .catch {
                    Log.d("SDdsdsdsds", it.message.toString())
                }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> Log.d("SDdsdsdsds", result.response.toString())
                        is Status.OnFailed -> Log.d(
                            "SDdsdsdsds",
                            result.throwable.message.toString()
                        )
                    }
                }
        }

    }
}