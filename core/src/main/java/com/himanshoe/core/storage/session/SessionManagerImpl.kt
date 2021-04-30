package com.himanshoe.core.storage.session

import android.content.Context
import com.himanshoe.core.storage.AppDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionManagerImpl @Inject constructor(@ApplicationContext private val context: Context) :
    SessionManager {

    override suspend fun saveStateId(stateId: Int) {
        AppDataStore.setInt(context, AppDataStore.STATE, stateId)
    }

    override suspend fun getStateId(): Int {
        return AppDataStore.getInt(context, AppDataStore.STATE)
    }
}