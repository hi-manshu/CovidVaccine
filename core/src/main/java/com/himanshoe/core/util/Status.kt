package com.himanshoe.core.util

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
sealed class Status<out DTO : Any> {

    data class OnSuccess<out DTO : Any>(val response: DTO) : Status<DTO>()

    data class OnFailed(val throwable: Throwable) : Status<Nothing>()

    object Loading : Status<Nothing>()
}