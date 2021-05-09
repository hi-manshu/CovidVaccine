package com.himanshoe.core.util

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by theapache64 : May 10 Mon,2021 @ 01:16
 * Fix for : https://github.com/hi-manshu/CovidVaccine/issues/13
 */
class UserAgentInterceptor : Interceptor {
    companion object {
        private const val DUMMY_USER_AGENT =
            "Mozilla/5.0 (Linux; Android 10; ONEPLUS A6000) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.99 Mobile Safari/537.36"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("User-Agent", DUMMY_USER_AGENT)
        return chain.proceed(request.build())
    }
}