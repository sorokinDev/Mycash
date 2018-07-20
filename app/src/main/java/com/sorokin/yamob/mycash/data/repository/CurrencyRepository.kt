package com.sorokin.yamob.mycash.data.repository

import com.sorokin.yamob.mycash.data.entity.MyCurrency
import javax.inject.Inject

class CurrencyRepository {

    companion object {
        val currencies = listOf(
                MyCurrency(0, "RUB", "Рубль"),
                MyCurrency(1, "USD", "Доллар"),
                MyCurrency(2, "EU", "Евро"),
                MyCurrency(3, "GBP", "Фунт")
        )
    }

    fun getAllCurrencies(): List<MyCurrency> = CurrencyRepository.currencies

    fun getFavoriteCurrencies(cnt: Int): List<MyCurrency> = getAllCurrencies().take(cnt).toList()

}