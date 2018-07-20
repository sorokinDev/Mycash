package com.sorokin.yamob.mycash.di.module

import com.sorokin.yamob.mycash.ui.home.HomeFragment
import com.sorokin.yamob.mycash.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBindingModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment


}