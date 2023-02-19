package com.nelsonxilv.filmapp.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nelsonxilv.filmapp.FilmNoFoundException
import com.nelsonxilv.filmapp.model.Film
import com.nelsonxilv.filmapp.model.FilmsService

class FilmDetailsViewModel(
    private val filmsService: FilmsService
) : ViewModel() {

    private val _filmDetails = MutableLiveData<Film>()
    val filmDetails: LiveData<Film> = _filmDetails

    fun loadFilm(filmId: Int) {
        if (_filmDetails.value != null) return
        try {
            _filmDetails.value = filmsService.getFilmById(filmId)
        } catch (e: FilmNoFoundException) {
            e.printStackTrace()
        }
    }

}