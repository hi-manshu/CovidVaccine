package com.himanshoe.onboarding.state.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.onboarding.state.data.response.StateResponse
import com.himanshoe.onboarding.state.domain.GetStatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StateViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val getStatesUseCase: GetStatesUseCase
) : BaseViewModel(networkHelper) {

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
}