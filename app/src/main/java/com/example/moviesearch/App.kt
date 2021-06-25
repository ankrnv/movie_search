package com.example.moviesearch

import android.app.Application
import com.example.moviesearch.di.AppComponent
import com.example.moviesearch.di.modules.DatabaseModule
import com.example.moviesearch.di.modules.DomainModule
import okhttp3.internal.Internal.instance


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteProvider(remoteProvider)
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}