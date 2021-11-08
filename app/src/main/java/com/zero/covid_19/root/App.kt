package com.zero.covid_19.root

import android.app.Application
import com.zero.covid_19.di.module.networkModule
import com.zero.covid_19.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, viewModelModule))
        }
    }
}