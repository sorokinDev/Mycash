package com.sorokin.yamob.mycash.ui.home

import android.content.SharedPreferences
import android.util.Log
import com.sorokin.yamob.mycash.data.repository.CurrencyRepository
import com.sorokin.yamob.mycash.ui.base.BaseFragmentViewModel
import com.sorokin.yamob.mycash.util.liveDataWithVal
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomeViewModel @Inject constructor(
        router: Router,
        var currencyRepository: CurrencyRepository
): BaseFragmentViewModel(router) {
    override val toolbarTitle = liveDataWithVal("Home")
    override val isToolbarVisible = liveDataWithVal(true)
    override val isBottomBarVisible = liveDataWithVal(true)

    var favoriteCurrencies = liveDataWithVal(currencyRepository.getFavoriteCurrencies(3))

}