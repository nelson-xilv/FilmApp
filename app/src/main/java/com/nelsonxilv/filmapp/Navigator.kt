package com.nelsonxilv.filmapp

import com.nelsonxilv.filmapp.model.Film

interface Navigator {

    fun showDetails(film: Film)

    fun goBack()

    fun toast(messageRes: Int)

}