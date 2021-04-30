package com.himanshoe.core.storage.session

import kotlinx.coroutines.flow.Flow

interface SessionManager {

    suspend fun saveStateId(stateId: Int)

    suspend fun getStateId(): Flow<Int>
}