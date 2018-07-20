package com.sorokin.yamob.mycash.util

import android.arch.lifecycle.MutableLiveData

fun <T> liveDataWithVal(defVal: T) = MutableLiveData<T>().apply { value =  defVal }