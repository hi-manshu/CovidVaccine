package com.himanshoe.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.storage.session.SessionManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl(): String {
        return "https://cdn-api.co-vin.in/"
    }


    @Provides
    fun provideSessionManager(sessionManagerImpl: SessionManagerImpl): SessionManager {
        return sessionManagerImpl
    }

}