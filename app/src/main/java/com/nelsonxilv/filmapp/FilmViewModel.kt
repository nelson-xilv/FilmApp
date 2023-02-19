package com.nelsonxilv.filmapp

import androidx.lifecycle.ViewModel
import com.nelsonxilv.filmapp.model.Film


class FilmViewModel : ViewModel() {

    var films = mutableListOf<Film>()

    init {
        films = (1..10).map {
            Film(
                id = it,
                name = R.string.film_name,
                photo = R.drawable.film,
                date_publication = R.string.date,
                rating = 5,
                description = R.string.description
            )
        }.toMutableList()
    }
}