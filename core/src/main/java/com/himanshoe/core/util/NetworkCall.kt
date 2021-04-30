package com.himanshoe.core.util

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException


typealias NetworkAPIInvoke<T> = suspend () -> Response<T>

suspend fun <T : Any> performNetworkCall(
    messageInCaseOfError: String = "Network error",
    allowRetries: Boolean = true,
    numberOfRetries: Int = 2,
    networkApiCall: NetworkAPIInvoke<T>
): Flow<Status<T>> {
    var delayDuration = 1000L
    val delayFactor = 2
    return flow {
        emit(Status.Loading)
        val response = networkApiCall()
        if (response.isSuccessful) {
            response.body()?.let { emit(Status.OnSuccess(it)) } ?: emit(
                Status.OnFailed(
                    IOException("API call successful but empty response body")
                )
            )
            return@flow
        }
        val error: ResponseBody? = response.errorBody()
        emit(Status.OnFailed(IOException(error.toString() ?: messageInCaseOfError)))
        return@flow
    }.catch { e ->
        emit(Status.OnFailed(IOException("Exception during network API call: ${e.message}")))
        return@catch
    }.retryWhen { cause, attempt ->
        if (!allowRetries || attempt > numberOfRetries || cause !is IOException) return@retryWhen false
        delay(delayDuration)
        delayDuration *= delayFactor
        return@retryWhen true
    }.flowOn(Dispatchers.IO)
}
