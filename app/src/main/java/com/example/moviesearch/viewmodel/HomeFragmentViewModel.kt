package com.example.moviesearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearch.App
import com.example.moviesearch.domain.Film
import com.example.moviesearch.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData = MutableLiveData<List<Film>>()
    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor
    init {
        //TODO init interactor

        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}