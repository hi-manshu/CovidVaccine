package com.himanshoe.onboarding.district.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.onboarding.deepLinkToDashboard
import com.himanshoe.onboarding.district.data.response.DistrictResponse
import com.himanshoe.onboarding.district.domain.GetListOfDistrictUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    fun init() {
        viewModelScope.launch {
            sessionManager.getStateId()
            districtUseCase.invoke(sessionManager.getStateId())
                .catch {
                    catchError()
                }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> {
                            _districtResponse.postValue(result.response)
                            _loading.postValue(false)
                        }
                        is Status.OnFailed -> catchError()
                        is Status.Loading -> _loading.postValue(true)

                    }
                }
        }
    }

    private fun catchError() {
        _districtResponse.postValue(null)
        _loading.postValue(false)
    }

    fun setDistrict(districtId: Int, name: String) {
        viewModelScope.launch {
            sessionManager.apply {
                sessionManager.savePinCodeForDistrict("")
                saveDistrictId(districtId)
                saveDistrictName(name)
                isOnboardingDone(true)
            }
            delay(1000)
            navigator.navigate(deepLinkToDashboard())
        }
    }
}