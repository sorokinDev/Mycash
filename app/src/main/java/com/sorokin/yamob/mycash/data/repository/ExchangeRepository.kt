package com.sorokin.yamob.mycash.data.repository

import com.sorokin.yamob.mycash.data.entity.Exchange
import com.sorokin.yamob.mycash.data.entity.MoneyBatch
import com.sorokin.yamob.mycash.data.entity.MyCurrency
import javax.inject.Inject


class ExchangeRepository @Inject constructor() {

    companion object {
        val exchanges = listOf(
                Exchange(CurrencyRepository.currencies[0], CurrencyRepository.currencies[1], 50.0),
                Exchange(CurrencyRepository.currencies[0], CurrencyRepository.currencies[2], 70.0),
                Exchange(CurrencyRepository.currencies[0], CurrencyRepository.currencies[3], 100.0),
                Exchange(CurrencyRepository.currencies[1], CurrencyRepository.currencies[2], 0.7),
                Exchange(CurrencyRepository.currencies[1], CurrencyRepository.currencies[3], 0.5),
                Exchange(CurrencyRepository.currencies[2], CurrencyRepository.currencies[3], 0.9)
        )
    }


    fun getExchangeRate(fromCurrency: MyCurrency, toCurrency: MyCurrency): Double{
        val ex= ExchangeRepository.exchanges.firstOrNull {
            return@firstOrNull (it.fromCurrency.id == fromCurrency.id && it.toCurrency.id == toCurrency.id) ||
                    (it.fromCurrency.id == toCurrency.id && it.toCurrency.id == fromCurrency.id)
        }
        if(ex == null){
            return 1.0
        }else{
            return if (ex.fromCurrency.id == fromCurrency.id) ex.rate else (1.0 / ex.rate)
        }
    }

    fun exchangeMoney(moneyBatch: MoneyBatch, toCurrency: MyCurrency): MoneyBatch =
            MoneyBatch(moneyBatch.amount * getExchangeRate(moneyBatch.currency, toCurrency), toCurrency)



}