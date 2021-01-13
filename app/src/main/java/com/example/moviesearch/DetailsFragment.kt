package com.example.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details)

        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        details_toolbar.title = film.title
        //Устанавливаем картинку
        details_poster.setImageResource(film.poster)
        //Устанавливаем описание
        details_description.text = film.description
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

}