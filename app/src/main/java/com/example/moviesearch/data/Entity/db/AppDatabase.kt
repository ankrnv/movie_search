package com.example.moviesearch.data.Entity.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesearch.data.Entity.Film
import com.example.moviesearch.data.Entity.dao.FilmDao

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

}