package com.nelsonxilv.filmapp.model

import androidx.annotation.StringRes

data class Film(
    val id: Int,
    @StringRes var name: Int,
    var photo: Int,
    @StringRes var date_publication: Int,
    var rating: Int,
    @StringRes var description: Int
)