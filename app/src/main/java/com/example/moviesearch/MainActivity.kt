package com.example.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigation()
    }

    val filmsDataBase = listOf(
        Film("Star Wars", R.drawable.poster_1, "This should be a description"),
        Film("Back to the Future", R.drawable.poster_2, "This should be a description"),
        Film("PulpFiction", R.drawable.poster_3, "This should be a description"),
        Film("Black Widow", R.drawable.poster_4, "This should be a description"),
        Film("Jaws", R.drawable.poster_5, "This should be a description"),
        Film("Blade Runner", R.drawable.poster_6, "This should be a description"),
        Film("Spider-Man", R.drawable.poster_7, "This should be a description"),
        Film("James Bond", R.drawable.poster_8, "This should be a description"),
        Film("Attack", R.drawable.poster_9, "This should be a description"),
        Film("Chicago", R.drawable.poster_10, "This should be a description"),
        Film("Titanic", R.drawable.poster_11, "This should be a description")
    )

    private fun initNavigation() {
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}