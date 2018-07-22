package com.sorokin.yamob.mycash.ui.settings


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sorokin.yamob.mycash.R
import com.sorokin.yamob.mycash.ui.base.BaseFragment
import com.sorokin.yamob.mycash.util.getViewModel
import javax.inject.Inject

class SettingsFragment @Inject constructor() : BaseFragment<SettingsViewModel>() {

    override fun provideViewModel(): SettingsViewModel = getViewModel(viewModelFactory)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }

}
