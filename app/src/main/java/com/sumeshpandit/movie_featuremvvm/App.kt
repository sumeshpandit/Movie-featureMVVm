package com.sumeshpandit.movie_featuremvvm

import android.app.Application
import com.sumeshpandit.movie_featuremvvm.di.NetworkModule
import com.sumeshpandit.movie_featuremvvm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, NetworkModule))
        }
    }

}