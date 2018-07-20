package com.sorokin.yamob.mycash.util

import android.arch.lifecycle.*
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment

inline fun <reified T : ViewModel> DaggerAppCompatActivity.getViewModel(
        viewModelFactory: ViewModelProvider.Factory
): T = ViewModelProviders.of(this, viewModelFactory)[T::class.java]

inline fun <reified T : ViewModel> DaggerFragment.getViewModel(
        viewModelFactory: ViewModelProvider.Factory
): T = ViewModelProviders.of(this, viewModelFactory)[T::class.java]

fun <T> LiveData<T>.observe(owner: LifecycleOwner, obs: (value: T?) -> Unit) =
    this.observe(owner, Observer { obs(it) })