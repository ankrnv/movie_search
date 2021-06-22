package com.example.moviesearch.viewmodel

import androidx.lifecycle.ViewModel
import com.amsdevelops.filmssearch.domain.Interactor
import com.example.moviesearch.App
import com.example.moviesearch.data.Entity.Film
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {

    val showProgressBar: BehaviorSubject<Boolean>
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData: Observable<List<Film>>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }

    fun getSearchResult(search: String) = interactor.getSearchResultFromApi(search)

    interface ApiCallback {
        fun onSuccess()
        fun onFailure()
    }
}