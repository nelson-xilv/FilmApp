package com.nelsonxilv.filmapp

import android.app.Application
import com.nelsonxilv.filmapp.model.FilmsService

class App : Application() {
    val filmsService = FilmsService()
}