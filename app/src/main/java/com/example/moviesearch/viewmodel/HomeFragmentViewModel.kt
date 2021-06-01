package com.example.moviesearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearch.App
import com.example.moviesearch.data.Entity.Film
import com.example.moviesearch.domain.Interactor
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {

    val showProgressBar: MutableLiveData<Boolean> = MutableLiveData()
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData: Flow<List<Film>>

    init {
        App.instance.dagger.inject(this)
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }

    interface ApiCallback {
        fun onSuccess()
        fun onFailure()
    }
}