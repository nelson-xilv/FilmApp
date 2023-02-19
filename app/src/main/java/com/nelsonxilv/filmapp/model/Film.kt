package com.nelsonxilv.filmapp.model

import androidx.annotation.StringRes

data class Film(
    val id: Int,
    @StringRes var name: Int,
    var film_poster: Int,
    @StringRes var date_publication: Int,
    var rating: Int,
    @StringRes var description: Int
)

// TODO("Create class FilmDetails")