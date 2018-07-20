package com.sorokin.yamob.mycash.data.repository

import com.sorokin.yamob.mycash.data.entity.MoneyBatch
import com.sorokin.yamob.mycash.data.entity.MyCurrency
import javax.inject.Inject

class WalletRepository @Inject constructor(){
    fun getCurrentBalance(): MoneyBatch = MoneyBatch(1000.0, CurrencyRepository.currencies[0])
}