package com.himanshoe.core.base.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Himanshu Singh on 12-04-2021.
 * hello2himanshusingh@gmail.com
 */
interface IDispatchersProvider {

    val ui: CoroutineDispatcher

    val io: CoroutineDispatcher

    val default: CoroutineDispatcher

}
