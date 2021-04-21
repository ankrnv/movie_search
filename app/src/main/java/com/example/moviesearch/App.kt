package com.example.moviesearch

import android.app.Application
import com.amsdevelops.filmssearch.di.modules.DatabaseModule
import com.amsdevelops.filmssearch.di.modules.DomainModule
import com.amsdevelops.filmssearch.di.modules.RemoteModule
import com.example.moviesearch.di.AppComponent
import com.example.moviesearch.di.DaggerAppComponent
import okhttp3.internal.Internal.instance


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}