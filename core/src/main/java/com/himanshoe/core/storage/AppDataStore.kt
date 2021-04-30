package com.himanshoe.core.storage

import android.content.Context
import com.himanshoe.core.base.datastore.DataStoreProvider

class AppDataStore(context: Context) : DataStoreProvider(context) {

    override fun prefName(): String {
        return "app-store"
    }
}