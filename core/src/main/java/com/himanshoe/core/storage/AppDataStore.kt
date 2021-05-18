package com.himanshoe.core.storage

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

val Context.dataStore by preferencesDataStore(name = "app-pref")

class AppDataStore {

    companion object {
        private val TAG = AppDataStore::class.simpleName
        const val STATE = "state"
        const val STATE_NAME = "state-name"
        const val DISTRICT = "district"
        const val AGE = "age"
        const val DISTRICT_NAME = "district-name"
        const val ONBOARDING = "onboarding"
        const val BANNER_DISMISS = "banner"
        const val TOKEN = "token"
        const val PHONE = "phone"
        const val PIN_CODE = "pincode"

        fun getBoolean(
            context: Context,
            keyName: String,
            defaultValue: Boolean = false
        ): Boolean {
            val key = booleanPreferencesKey(keyName)
            val data: Flow<Boolean> = context.dataStore.data.map {
                it[key] ?: defaultValue
            }
            return getData(data, defaultValue)
        }

        fun setBoolean(context: Context, keyName: String, value: Boolean) {
            val key = booleanPreferencesKey(keyName)
            setData(context, key, value)
        }

        fun getInt(context: Context, keyName: String, defaultValue: Int = 0): Int {
            val key = intPreferencesKey(keyName)
            val data: Flow<Int> = context.dataStore.data.map {
                it[key] ?: defaultValue
            }
            return getData(data, defaultValue)
        }

        fun setInt(context: Context, keyName: String, value: Int) {
            val key = intPreferencesKey(keyName)
            setData(context, key, value)
        }

        fun getLong(context: Context, keyName: String, defaultValue: Long = 0L): Long {
            val key = longPreferencesKey(keyName)
            val data: Flow<Long> = context.dataStore.data.map {
                it[key] ?: defaultValue
            }
            return getData(data, defaultValue)
        }

        fun setLong(context: Context, keyName: String, value: Long) {
            val key = longPreferencesKey(keyName)
            setData(context, key, value)
        }

        fun getFloat(context: Context, keyName: String, defaultValue: Float = 0f): Float {
            val key = floatPreferencesKey(keyName)
            val data: Flow<Float> = context.dataStore.data.map {
                it[key] ?: defaultValue
            }
            return getData(data, defaultValue)
        }

        fun setFloat(context: Context, keyName: String, value: Float) {
            val key = floatPreferencesKey(keyName)
            setData(context, key, value)
        }

        fun getDouble(
            context: Context,
            keyName: String,
            defaultValue: Double = 0.0
        ): Double {
            val key = doublePreferencesKey(keyName)
            val data: Flow<Double> = context.dataStore.data.map {
                it[key] ?: defaultValue
            }
            return getData(data, defaultValue)
        }

        fun setDouble(context: Context, keyName: String, value: Double) {
            val key = doublePreferencesKey(keyName)
            setData(context, key, value)
        }

        fun getString(
            context: Context,
            keyName: String,
            defaultValue: String = ""
        ): String {
            val key = stringPreferencesKey(keyName)
            val data: Flow<String> = context.dataStore.data.map {
                it[key] ?: defaultValue
            }
            return getData(data, defaultValue)
        }

        fun setString(context: Context, keyName: String, value: String) {
            val key = stringPreferencesKey(keyName)
            setData(context, key, value)
        }

        private fun <T> getData(data: Flow<T>, defaultValue: T): T {
            return runBlocking {
                try {
                    return@runBlocking data.first()
                } catch (e: NoSuchElementException) {
                    e.message?.let { Log.e(TAG, e.printStackTrace().toString()) }
                    return@runBlocking defaultValue
                }
            }
        }

        private fun <T> setData(context: Context, key: Preferences.Key<T>, value: T) {
            runBlocking {
                context.dataStore.edit { data ->
                    data[key] = value
                }
            }
        }
    }
}