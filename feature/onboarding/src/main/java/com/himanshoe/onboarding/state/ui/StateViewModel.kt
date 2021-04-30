package com.himanshoe.onboarding.state.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.onboarding.deeplinkToDistrict
import com.himanshoe.onboarding.state.data.response.StateResponse
import com.himanshoe.onboarding.state.domain.GetStatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StateViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val getStatesUseCase: GetStatesUseCase,
    private val sessionManager: SessionManager
) : BaseViewModel(networkHelper) {

    val navigator = Navigator()

    private val _stateReponse = MutableLiveData<StateResponse?>()
    val stateReponse: LiveData<StateResponse?>
        get() = _stateReponse

    fun init() {
        viewModelScope.launch {
            getStatesUseCase.invoke(Unit)
                .catch {
                    catchError()
                }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> _stateReponse.postValue(result.response)
                        is Status.OnFailed -> catchError()
                    }
                }
        }
    }

    private fun catchError() {
        _stateReponse.postValue(null)
    }

    fun saveState(stateId: Int) {
        viewModelScope.launch {
            sessionManager.saveStateId(stateId)
            delay(2000)
            navigator.navigate(deeplinkToDistrict())
        }
    }
}