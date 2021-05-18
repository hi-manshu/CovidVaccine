package com.himanshoe.login.data

import com.himanshoe.core.util.Status
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun doLogin(loginRequest: LoginRequest): Flow<Status<LoginResponse>>
}