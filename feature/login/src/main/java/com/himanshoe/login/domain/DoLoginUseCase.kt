package com.himanshoe.login.domain

import com.himanshoe.core.base.BaseUseCase
import com.himanshoe.core.util.Status
import com.himanshoe.login.data.LoginRepository
import com.himanshoe.login.data.LoginRequest
import com.himanshoe.login.data.LoginResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DoLoginUseCase @Inject constructor(private val loginRepository: LoginRepository) :
    BaseUseCase<LoginRequest, LoginResponse> {

    override suspend fun invoke(input: LoginRequest): Flow<Status<LoginResponse>> {
        return loginRepository.doLogin(input)
    }
}