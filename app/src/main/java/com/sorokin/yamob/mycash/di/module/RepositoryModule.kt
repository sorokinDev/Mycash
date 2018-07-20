package com.sorokin.yamob.mycash.di.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.sorokin.yamob.mycash.data.repository.CurrencyRepository
import com.sorokin.yamob.mycash.data.repository.ExchangeRepository
import com.sorokin.yamob.mycash.data.repository.WalletRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCurrencyRepository(): CurrencyRepository = CurrencyRepository()

    @Provides
    @Singleton
    fun provideExchangeRepository(): ExchangeRepository = ExchangeRepository()

    @Provides
    @Singleton
    fun provideWalletRepository(): WalletRepository = WalletRepository()
}