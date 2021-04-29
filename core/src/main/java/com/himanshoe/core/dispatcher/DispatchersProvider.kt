package com.himanshoe.core.base.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created by Himanshu Singh on 12-04-2021.
 * hello2himanshusingh@gmail.com
 */
class DispatchersProvider @Inject constructor() : IDispatchersProvider {

    override val ui: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
}