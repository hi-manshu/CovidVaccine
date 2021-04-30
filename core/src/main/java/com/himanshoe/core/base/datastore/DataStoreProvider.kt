package com.himanshoe.core.base.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

abstract class DataStoreProvider(val context: Context) : IDataStoreProvider {

    private val Context.dataStore:
            DataStore<Preferences> by preferencesDataStore(name = prefName())

    private var dataStore: DataStore<Preferences> = context.dataStore

    fun <T> getValue(key: Preferences.Key<T>, DEFAULT: T): Flow<T> {
        return dataStore.data.catch { emit(emptyPreferences()) }
            .map { preference -> preference[key] ?: DEFAULT }
    }

    fun <T> getValue(key: Preferences.Key<T>): Flow<T?> {
        return dataStore.data.catch { emit(emptyPreferences()) }
            .map { preference -> preference[key] }
    }

    suspend fun <T> getSync(key: Preferences.Key<T>): T? {
        return dataStore.data.firstOrNull()?.get(key)
    }

    suspend fun <T> getSync(key: Preferences.Key<T>, default: T): T {
        return getSync(key) ?: default
    }

    suspend fun <T> setValue(key: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }
}
