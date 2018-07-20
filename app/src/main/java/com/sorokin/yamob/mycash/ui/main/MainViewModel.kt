package com.sorokin.yamob.mycash.ui.main

import android.arch.lifecycle.ViewModel
import android.content.SharedPreferences
import android.util.Log
import com.sorokin.yamob.mycash.data.repository.CurrencyRepository
import com.sorokin.yamob.mycash.ui.base.BaseViewModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainViewModel @Inject constructor(
        router: Router

): BaseViewModel(router) {

}
