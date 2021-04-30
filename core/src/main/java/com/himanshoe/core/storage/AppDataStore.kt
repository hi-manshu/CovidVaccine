package com.himanshoe.core.storage

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import com.himanshoe.core.base.datastore.DataStoreProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppDataStore @Inject constructor(@ApplicationContext context: Context) :
    DataStoreProvider(context) {

    private object PreferencesKeys {
        val STATE_ID = intPreferencesKey("state_id")
    }

    override fun prefName(): String {
        return "app-store"
    }

    suspend fun setStateId(stateId: Int) {
        setValue(PreferencesKeys.STATE_ID, stateId)
    }

    suspend fun getStateId(): Flow<Int> {
        return getValue(PreferencesKeys.STATE_ID, 0)
    }
}