package com.himanshoe.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.NavigateTo
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.login.data.LoginRequest
import com.himanshoe.login.data.LoginResponse
import com.himanshoe.login.data.OtpRequest
import com.himanshoe.login.data.OtpResponse
import com.himanshoe.login.domain.DoLoginUseCase
import com.himanshoe.login.domain.DoLoginWithOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val sessionManager: SessionManager,
    private val doLoginUseCase: DoLoginUseCase,
    private val doLoginWithOtpUseCase: DoLoginWithOtpUseCase
) : BaseViewModel(networkHelper) {

    val navigator = Navigator()

    private val _loginResponse = MutableLiveData(LoginResponse(""))
    val loginResponse: LiveData<LoginResponse>
        get() = _loginResponse

    private val _loginWithOtpResponse = MutableLiveData(OtpResponse(""))
    val loginWithOtpResponse: LiveData<OtpResponse>
        get() = _loginWithOtpResponse

    fun goBack() {
        navigator.navigate(NavigateTo.Back)
    }

    fun doLogin(loginRequest: LoginRequest) {
        viewModelScope.launch {
            doLoginUseCase.invoke(loginRequest)
                .catch { Log.d("SDdfsf", it.message.toString()) }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> _loginResponse.postValue(result.response)
                        is Status.OnFailed -> Log.d("SDdfsf", result.throwable.message.toString())
                    }
                }
        }
    }

    fun authenticateUsingOtp(otpRequest: OtpRequest) {
        viewModelScope.launch {
            doLoginWithOtpUseCase.invoke(otpRequest)
                .catch { Log.d("SDdfsf", it.message.toString()) }
                .collect { result ->
                    when (result) {
                        is Status.OnSuccess -> _loginWithOtpResponse.postValue(result.response)
                        is Status.OnFailed -> Log.d("SDdfsf", result.throwable.message.toString())
                    }
                }
        }
    }

    fun setupUser(otpResponse: OtpResponse?) {
        if (otpResponse != null) {
            viewModelScope.launch {
                sessionManager.saveToken(otpResponse.token)
                delay(1000)
                navigator.navigate(NavigateTo.Back)
            }
        }
    }
}