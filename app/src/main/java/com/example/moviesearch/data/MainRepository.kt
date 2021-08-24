package com.example.moviesearch.data

import android.content.ContentValues
import android.database.Cursor
import androidx.lifecycle.LiveData
import com.example.moviesearch.data.Entity.db.AppDatabase
import com.example.moviesearch.data.Entity.Film
import com.example.moviesearch.data.Entity.dao.FilmDao
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

    fun deleteAll() {
        filmDao.deleteAll()
    }
}
