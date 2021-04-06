package com.amsdevelops.filmssearch.di.modules

import com.example.moviesearch.data.MainRepository
import com.example.moviesearch.data.TmdbApi
import com.example.moviesearch.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}