package com.himanshoe.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.himanshoe.core.navigation.event.Event
import com.himanshoe.core.util.NetworkHelper

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
abstract class BaseViewModel(private val networkHelper: NetworkHelper) : ViewModel() {

    val _error = MutableLiveData<Event<String>>()
    val error: LiveData<Event<String>>
        get() = _error


    companion object {
        val NETWORK_ERROR = "No internet Connection"
    }

    fun isNetworkConnected(): Boolean {
        return networkHelper.isNetworkConnected()
    }

}