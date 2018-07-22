package com.sorokin.yamob.mycash.di.module

import android.arch.lifecycle.ViewModel
import com.sorokin.yamob.mycash.ui.home.HomeViewModel
import com.sorokin.yamob.mycash.ui.main.MainViewModel
import com.sorokin.yamob.mycash.ui.settings.SettingsViewModel
import com.sorokin.yamob.mycash.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel : MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel : HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsModel(viewModel : SettingsViewModel) : ViewModel
}