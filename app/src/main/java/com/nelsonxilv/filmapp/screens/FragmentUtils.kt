package com.nelsonxilv.filmapp.screens

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nelsonxilv.filmapp.App
import com.nelsonxilv.filmapp.Navigator

class ViewModelFactory(
    private val app: App
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass) {
            FilmsListViewModel::class.java -> {
                FilmsListViewModel(app.filmsService)
            }
            FilmDetailsViewModel::class.java -> {
                FilmDetailsViewModel(app.filmsService)
            }
            else -> {
                throw IllegalStateException("Unknown viewModel class")
            }
        }

        return viewModel as T
    }

}

fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)

fun Fragment.navigation() = requireActivity() as Navigator