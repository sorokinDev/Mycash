package com.sorokin.yamob.mycash.ui.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sorokin.yamob.mycash.R
import com.sorokin.yamob.mycash.ui.base.BaseFragment
import com.sorokin.yamob.mycash.util.getViewModel
import javax.inject.Inject


class HomeFragment @Inject constructor() : BaseFragment<HomeViewModel>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HomeFragment", "Hello from home")
    }

    override fun provideViewModel(): HomeViewModel = getViewModel(viewModelFactory)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}
