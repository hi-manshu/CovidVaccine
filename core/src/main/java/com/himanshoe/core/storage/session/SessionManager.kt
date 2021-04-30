package com.himanshoe.core.storage.session

interface SessionManager {

    suspend fun saveStateId(stateId: Int)

    suspend fun getStateId(): Int
}