package com.himanshoe.core.storage.session

import com.himanshoe.core.storage.AppDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SessionManagerImpl @Inject constructor(private val appDataStore: AppDataStore) :
    SessionManager {

    override suspend fun saveStateId(stateId: Int) {
        appDataStore.setStateId(stateId)
    }

    override suspend fun getStateId(): Flow<Int> {
        return appDataStore.getStateId()
    }
}