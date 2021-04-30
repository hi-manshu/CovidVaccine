package com.himanshoe.onboarding.district.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.onboarding.district.data.response.DistrictResponse
import com.himanshoe.onboarding.district.domain.GetListOfDistrictUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DistrictViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val sessionManager: SessionManager,
    private val districtUseCase: GetListOfDistrictUseCase
) : BaseViewModel(networkHelper) {

    val navigator = Navigator()

    private val _districtResponse = MutableLiveData<DistrictResponse?>()
    val districtResponse: LiveData<DistrictResponse?>
        get() = _districtResponse

    fun init() {
        viewModelScope.launch {
            sessionManager.getStateId()
            districtUseCase.invoke(sessionManager.getStateId())
                .catch {
                    catchError()
                }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> _districtResponse.postValue(result.response)
                        is Status.OnFailed -> catchError()
                    }
                }
        }
    }

    private fun catchError() {
        _districtResponse.postValue(null)
    }

}