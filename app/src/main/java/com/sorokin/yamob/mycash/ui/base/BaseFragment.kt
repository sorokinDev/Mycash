package com.sorokin.yamob.mycash.ui.base

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.view.View
import com.sorokin.yamob.mycash.R
import com.sorokin.yamob.mycash.ui.main.MainActivity
import com.sorokin.yamob.mycash.ui.main.MainViewModel
import com.sorokin.yamob.mycash.util.ViewModelFactory
import com.sorokin.yamob.mycash.util.getViewModel
import com.sorokin.yamob.mycash.util.observe
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<T: BaseFragmentViewModel>: DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: T

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.isToolbarVisible.observe(this) {
            if(activity != null && activity is MainActivity)
                (activity as MainActivity).setToolbarVisibility(it ?: true)
        }

        viewModel.toolbarTitle.observe(this){
            activity?.title = it ?: getString(R.string.app_name)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = provideViewModel()
    }

    abstract fun provideViewModel(): T

}
