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

    override suspend fun saveStateName(name: String) {
        AppDataStore.setString(context, AppDataStore.STATE_NAME, name)
    }

    override suspend fun saveDistrictName(name: String) {
        AppDataStore.setString(context, AppDataStore.DISTRICT_NAME, name)
    }

    override suspend fun getStateId(): Int {
        return AppDataStore.getInt(context, AppDataStore.STATE)
    }

    override suspend fun getStateName(): String {
        return AppDataStore.getString(context, AppDataStore.STATE_NAME)
    }

    override suspend fun getDistrictName(): String {
        return AppDataStore.getString(context, AppDataStore.DISTRICT_NAME)
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