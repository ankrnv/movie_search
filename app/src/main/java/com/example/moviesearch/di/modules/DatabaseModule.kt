package com.example.moviesearch.di.modules

import android.content.Context
import androidx.room.Room
import com.example.moviesearch.data.Entity.dao.FilmDao
import com.example.moviesearch.data.Entity.db.AppDatabase
import com.example.moviesearch.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}