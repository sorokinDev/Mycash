package com.sorokin.yamob.mycash.ui.settings

import android.arch.lifecycle.MutableLiveData
import com.sorokin.yamob.mycash.ui.base.BaseFragmentViewModel
import com.sorokin.yamob.mycash.util.liveDataWithVal
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
        router: Router
): BaseFragmentViewModel(router) {
    override val toolbarTitle: MutableLiveData<String> = liveDataWithVal("Settings")
    override val isToolbarVisible: MutableLiveData<Boolean> = liveDataWithVal(true)
    override val isBottomBarVisible: MutableLiveData<Boolean> = liveDataWithVal(true)
}