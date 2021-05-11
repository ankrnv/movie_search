package com.amsdevelops.filmssearch.di.modules

import android.content.Context
import com.example.moviesearch.data.Entity.db.AppDatabase
import com.example.moviesearch.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabaseHelper(context: Context) = AppDatabase(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: AppDatabase) = MainRepository(databaseHelper)
}