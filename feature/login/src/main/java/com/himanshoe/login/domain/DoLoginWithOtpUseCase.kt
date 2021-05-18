package com.himanshoe.login.domain

import com.himanshoe.core.base.BaseUseCase
import com.himanshoe.core.util.Status
import com.himanshoe.login.data.LoginRepository
import com.himanshoe.login.data.OtpRequest
import com.himanshoe.login.data.OtpResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DoLoginWithOtpUseCase @Inject constructor(private val loginRepository: LoginRepository) :
    BaseUseCase<OtpRequest, OtpResponse> {

    override suspend fun invoke(input: OtpRequest): Flow<Status<OtpResponse>> {
        return loginRepository.doLoginWithOtp(input)
    }
}