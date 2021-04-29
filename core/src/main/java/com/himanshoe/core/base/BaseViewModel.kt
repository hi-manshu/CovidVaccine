package com.himanshoe.core.base

import androidx.lifecycle.ViewModel
import com.himanshoe.core.util.NetworkHelper

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
abstract class BaseViewModel(private val networkHelper: NetworkHelper) : ViewModel() {

    companion object {
        val NETWORK_ERROR = "No internet Connection"
    }

    fun isNetworkConnected(): Boolean {
        return networkHelper.isNetworkConnected()
    }

}