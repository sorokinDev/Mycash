package com.sorokin.yamob.mycash.ui.base

import android.arch.lifecycle.ViewModel
import com.sorokin.yamob.mycash.util.ViewModelKey
import ru.terrakok.cicerone.Router
import javax.inject.Inject

abstract class BaseViewModel constructor(
        val router: Router
): ViewModel() {

}