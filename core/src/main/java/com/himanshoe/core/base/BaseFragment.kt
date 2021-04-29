package com.himanshoe.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import com.himanshoe.core.util.setupView

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        val view = setupView {
            SetupView()
        }
        setupObserver()
        return view
    }

    protected abstract fun setupObserver()

    protected abstract fun init()

    @Composable
    protected abstract fun SetupView()
}