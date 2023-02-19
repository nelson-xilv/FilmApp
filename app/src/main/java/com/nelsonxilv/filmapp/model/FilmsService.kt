package com.nelsonxilv.filmapp.model

import com.nelsonxilv.filmapp.FilmNoFoundException
import com.nelsonxilv.filmapp.R

typealias FilmsListener = (films: List<Film>) -> Unit

class FilmsService {

    private var films = mutableListOf<Film>()

    private val listeners = mutableSetOf<FilmsListener>()

    init {
        films = (1..10).map {
            Film(
                id = it,
                name = R.string.name_film,
                film_poster = R.drawable.film_poster,
                date_publication = R.string.date,
                rating = 5,
                description = R.string.description
            )
        }.toMutableList()
    }

    fun getFilmById(id: Int): Film {
        return films.firstOrNull { it.id == id } ?: throw FilmNoFoundException()
    }

    fun addListener(listener: FilmsListener) {
        listeners.add(listener)
        listener.invoke(films)
    }

    fun removeListener(listener: FilmsListener) {
        listeners.remove(listener)
    }
}