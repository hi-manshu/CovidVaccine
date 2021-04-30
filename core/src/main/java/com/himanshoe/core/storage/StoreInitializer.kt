package com.himanshoe.core.storage

import android.content.Context

object StoreInitializer {

    private fun initializer(context: Context) {
        AppDataStore(context)
    }

    fun init(context: Context) {
        initializer(context)
    }
}