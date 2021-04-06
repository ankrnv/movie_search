package com.example.moviesearch

import android.app.Application
import com.example.moviesearch.data.ApiConstants
import com.example.moviesearch.data.MainRepository
import com.example.moviesearch.data.TmdbApi
import com.example.moviesearch.di.AppComponent
import com.example.moviesearch.di.DI
import com.example.moviesearch.domain.Interactor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}