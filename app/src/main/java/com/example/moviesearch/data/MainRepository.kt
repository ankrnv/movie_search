package com.example.moviesearch.data

import android.content.ContentValues
import android.database.Cursor
import com.example.moviesearch.data.Entity.db.AppDatabase
import com.example.moviesearch.data.Entity.Film
import com.example.moviesearch.data.Entity.dao.FilmDao
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): List<Film> {
        return filmDao.getCachedFilms()
    }

//    //Инициализируем объект для взаимодействия с БД
//    private val sqlDb = databaseHelper.readableDatabase
//    //Создаем курсор для обработки запросов из БД
//    private lateinit var cursor: Cursor
//
//    fun putToDb(film: Film) {
//        //Создаем объект, который будет хранить пары ключ-значение, для того
//        //чтобы класть нужные данные в нужные столбцы
//        val cv = ContentValues()
//        cv.apply {
//            put(AppDatabase.COLUMN_TITLE, film.title)
//            put(AppDatabase.COLUMN_POSTER, film.poster)
//            put(AppDatabase.COLUMN_DESCRIPTION, film.description)
//            put(AppDatabase.COLUMN_RATING, film.rating)
//        }
//        //Кладем фильм в БД
//        sqlDb.insert(AppDatabase.TABLE_NAME, null, cv)
//    }
//
//    fun getAllFromDB(): List<Film> {
//        //Создаем курсор на основании запроса "Получить все из таблицы"
//        cursor = sqlDb.rawQuery("SELECT * FROM ${AppDatabase.TABLE_NAME}", null)
//        //Сюда будем сохранять результат получения данных
//        val result = mutableListOf<Film>()
//        //Проверяем, есть ли хоть одна строка в ответе на запрос
//        if (cursor.moveToFirst()) {
//            //Итерируемся по таблице, пока есть записи, и создаем на основании объект Film
//            do {
//                val title = cursor.getString(1)
//                val poster = cursor.getString(2)
//                val description = cursor.getString(3)
//                val rating = cursor.getDouble(4)
//
//                result.add(
//                    Film(
//                        title,
//                        poster,
//                        description,
//                        rating
//                    )
//                )
//            } while (cursor.moveToNext())
//        }
//        //Возвращаем список фильмов
//        return result
//    }
}

//    val filmsDataBase = listOf(
//        Film("Star Wars",
//            R.drawable.poster_1, "Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.", 8.7f),
//        Film("Back to the Future",
//            R.drawable.poster_2, "Marty McFly, a 17-year-old high school student, is accidentally sent thirty years into the past in a time-traveling DeLorean invented by his close friend, the eccentric scientist Doc Brown.", 8.5f),
//        Film("Pulp Fiction",
//            R.drawable.poster_3, "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", 8.2f),
//        Film("Black Widow",
//            R.drawable.poster_4, "A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.", 7.1f),
//        Film("Jaws",
//            R.drawable.poster_5, "When a killer shark unleashes chaos on a beach community, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down.", 7.7f),
//        Film("Blade Runner",
//            R.drawable.poster_6, "A blade runner must pursue and terminate four replicants who stole a ship in space, and have returned to Earth to find their creator.", 7.9f),
//        Film("Spider-Man",
//            R.drawable.poster_7, "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.", 7.1f),
//        Film("James Bond",
//            R.drawable.poster_8, "James Bond has left active service. His peace is short-lived when Felix Leiter, an old friend from the CIA, turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.", 6.8f),
//        Film("Attack",
//            R.drawable.poster_9, "When an abused socialite grows to giant size because of an alien encounter and an aborted murder attempt, she goes after her cheating husband with revenge on her mind.", 5.7f),
//        Film("Chicago",
//            R.drawable.poster_10, "Two death-row murderesses develop a fierce rivalry while competing for publicity, celebrity, and a sleazy lawyer's attention.", 7.8f),
//        Film("Titanic",
//            R.drawable.poster_11, "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", 8.6f)
//    )
