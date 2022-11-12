package com.example.ghurskykursach.data.di

import android.app.Application
import com.example.improvedcrypto.files.data.module.appModule
import com.example.improvedcrypto.files.data.module.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinApp)
            modules(listOf(appModule, retrofitModule))
        }
    }
}