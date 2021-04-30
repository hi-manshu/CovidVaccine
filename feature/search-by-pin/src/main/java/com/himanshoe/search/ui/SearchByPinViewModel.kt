package com.himanshoe.search.ui

import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.search.domain.GetLocationByPinCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchByPinViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val getLocationByPinCodeUseCase: GetLocationByPinCodeUseCase
) : BaseViewModel(networkHelper) {

    val navigator = Navigator()

    fun init(pinCode: String) {

    }
}