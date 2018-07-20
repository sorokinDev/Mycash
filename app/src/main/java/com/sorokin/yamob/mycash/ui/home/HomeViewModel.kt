package com.sorokin.yamob.mycash.ui.home

import android.content.SharedPreferences
import com.sorokin.yamob.mycash.ui.base.BaseFragmentViewModel
import com.sorokin.yamob.mycash.util.liveDataWithVal
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomeViewModel @Inject constructor(
        router: Router
): BaseFragmentViewModel(router) {
    override val toolbarTitle = liveDataWithVal("Home")
    override val isToolbarVisible = liveDataWithVal(true)
    override val isBottomBarVisible = liveDataWithVal(true)
}