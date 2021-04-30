package com.himanshoe.search.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.himanshoe.core.base.BaseViewModel
import com.himanshoe.core.navigation.Navigator
import com.himanshoe.core.storage.session.SessionManager
import com.himanshoe.core.util.NetworkHelper
import com.himanshoe.core.util.Status
import com.himanshoe.search.data.request.SearchByPinRequest
import com.himanshoe.search.data.response.SearchByPinResponse
import com.himanshoe.search.domain.GetLocationByPinCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchByPinViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    private val getLocationByPinCodeUseCase: GetLocationByPinCodeUseCase,
    private val sessionManager: SessionManager
) : BaseViewModel(networkHelper) {

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String>
        get() = _searchQuery

    private val _locationResponse = MutableLiveData<SearchByPinResponse?>()
    val locationResponse: LiveData<SearchByPinResponse?>
        get() = _locationResponse

    val navigator = Navigator()

    @FlowPreview
    fun onSearch(searchQuery: String) {
        viewModelScope.launch {
            flowOf(searchQuery)
                .debounce(300)
                .filter { query ->
                    return@filter query.isNotEmpty()
                }
                .distinctUntilChanged()
                .collect {
                    _searchQuery.postValue(it)
                }
        }
    }

    fun fetchLocation(pinCode: String) {
        viewModelScope.launch {
            getLocationByPinCodeUseCase.invoke(
                SearchByPinRequest(
                    pinCode,
                    sessionManager.getCurrentDate()
                )
            ).catch {
                catchError()
            }.collect { result ->
                when (result) {
                    is Status.OnSuccess -> _locationResponse.postValue(result.response)
                    is Status.OnFailed -> catchError()
                }
            }
        }
    }

    private fun catchError() {
        _locationResponse.postValue(null)
    }
}