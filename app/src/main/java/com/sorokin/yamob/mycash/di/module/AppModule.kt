package com.sorokin.yamob.mycash.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import com.sorokin.yamob.mycash.App
import com.sorokin.yamob.mycash.ui.main.MainViewModel
import dagger.Provides
import javax.inject.Singleton
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import dagger.Binds



@Module(includes = [
    ViewModelModule::class
])
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreference(app: Application): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(app)

    private var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(): Router {
        return cicerone.getRouter()
    }

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

}