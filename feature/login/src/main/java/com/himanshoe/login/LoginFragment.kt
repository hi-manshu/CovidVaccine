package com.himanshoe.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.login.component.LoginToolbar
import com.himanshoe.login.component.MobileInput
import com.himanshoe.login.data.LoginRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class LoginFragment : BaseFragment() {

    private val viewModel by viewModels<LoginViewModel>()

    override fun setupObserver() {

    }

    override fun init() {
        viewModel.navigator.navigateBy(this)
    }

    @ExperimentalComposeUiApi
    @Composable
    override fun SetupView() {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {
                    LoginToolbar {
                        viewModel.goBack()
                    }
                }
            }) {
                MobileInput {number->
                    viewModel.doLogin(LoginRequest(number.toString()) )
                }
        }
    }


}