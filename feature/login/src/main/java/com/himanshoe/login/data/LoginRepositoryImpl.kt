package com.himanshoe.login.data

import com.himanshoe.core.util.Status
import com.himanshoe.core.util.performNetworkCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(val loginApiService: LoginApiService) :
    LoginRepository {

    override suspend fun doLogin(loginRequest: LoginRequest): Flow<Status<LoginResponse>> {
        return performNetworkCall { loginApiService.doLogin(loginRequest) }
    }

    override suspend fun doLoginWithOtp(otpRequest: OtpRequest): Flow<Status<OtpResponse>> {
        return performNetworkCall { loginApiService.doLoginWithOtp(otpRequest) }
    }
}