package com.example.moviesearch.data.Entity.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviesearch.data.Entity.Film
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {
    @Query("SELECT * FROM cached_films")
    fun getCachedFilms(): Flow<List<Film>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Film>)

    @Query("DELETE FROM cached_films")
    fun deleteAll()
}