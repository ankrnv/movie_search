package com.example.moviesearch.data.Entity.dao

import androidx.room.*
import com.example.moviesearch.data.Entity.Film
import io.reactivex.rxjava3.core.Observable

@Dao
interface FilmDao {
    @Query("SELECT * FROM cached_films")
    fun getCachedFilms(): Observable<List<Film>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Film>)

    @Query("DELETE FROM cached_films")
    fun deleteAll()
}