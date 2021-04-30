package com.himanshoe.core.storage.session

import android.content.Context
import com.himanshoe.core.storage.AppDataStore
import com.himanshoe.core.util.DateUtil
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

    override suspend fun saveDistrictId(districtId: Int) {
        AppDataStore.setInt(context, AppDataStore.DISTRICT, districtId)
    }

    override suspend fun getDistrictId(): Int {
        return AppDataStore.getInt(context, AppDataStore.DISTRICT)
    }

    override suspend fun isOnboardingDone(status: Boolean) {
        AppDataStore.setBoolean(context, AppDataStore.ONBOARDING, status)
    }

    override suspend fun isOnboardingDone(): Boolean {
        return AppDataStore.getBoolean(context, AppDataStore.ONBOARDING)
    }

    override suspend fun getCurrentDate(): String {
        return DateUtil.currentDateInString()
    }
}