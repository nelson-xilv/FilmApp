package com.nelsonxilv.filmapp.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nelsonxilv.filmapp.model.Film
import com.nelsonxilv.filmapp.model.FilmsListener
import com.nelsonxilv.filmapp.model.FilmsService

class FilmsListViewModel(
    private val filmsService: FilmsService
) : ViewModel() {

    private val _films = MutableLiveData<List<Film>>()
    val films: LiveData<List<Film>> = _films

    private val listener: FilmsListener = {
        _films.value = it
    }

    init {
        loadFilms()
    }

    override fun onCleared() {
        super.onCleared()
        filmsService.removeListener(listener)
    }

    fun loadFilms() {
        filmsService.addListener(listener)
    }

}