package com.himanshoe.onboarding.state.ui

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

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    fun init() {
        viewModelScope.launch {
            getStatesUseCase.invoke(Unit)
                .catch {
                    catchError()
                }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> {
                            _stateReponse.postValue(result.response)
                            _loading.postValue(false)
                        }
                        is Status.OnFailed -> catchError()
                        is Status.Loading -> _loading.postValue(true)
                    }
                }
        }
    }

    private fun catchError() {
        _stateReponse.postValue(null)
        _loading.postValue(false)
    }

    fun saveState(stateId: Int, name: String) {
        viewModelScope.launch {
            sessionManager.apply {
                saveStateId(stateId)
                saveStateName(name)
            }
            delay(2000)
            navigator.navigate(deeplinkToDistrict())
        }
    }
}