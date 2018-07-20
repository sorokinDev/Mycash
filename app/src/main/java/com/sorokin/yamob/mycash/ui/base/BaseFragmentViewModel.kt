package com.sorokin.yamob.mycash.ui.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import ru.terrakok.cicerone.Router

abstract class BaseFragmentViewModel constructor(
        router: Router
) : BaseViewModel(router){
    abstract val toolbarTitle: MutableLiveData<String>
    abstract val isToolbarVisible: MutableLiveData<Boolean>
    abstract val isBottomBarVisible: MutableLiveData<Boolean>
}