package com.nelsonxilv.filmapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nelsonxilv.filmapp.databinding.FragmentFilmDetailsBinding

class FilmDetailsFragment : Fragment() {

    private lateinit var binding: FragmentFilmDetailsBinding
    private val viewModel: FilmDetailsViewModel by viewModels { factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadFilm(requireArguments().getInt(ARG_FILM_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmDetailsBinding.inflate(inflater, container, false)

        viewModel.filmDetails.observe(viewLifecycleOwner) {

            with(binding) {
                nameFilmTextView.setText(it.name)
                posterFilmImageview.setImageResource(it.film_poster)
                datePublicationTextview.setText(it.date_publication)
                ratingFilmRatingbar.rating = it.rating.toFloat()
                descriptionFilmTextview.setText(it.description)
            }

        }

        return binding.root
    }

    companion object {

        private const val ARG_FILM_ID = "ARG_FILM_ID"

        fun newInstance(filmId: Int): FilmDetailsFragment {
            val fragment = FilmDetailsFragment()
            fragment.arguments = bundleOf(ARG_FILM_ID to filmId)
            return fragment
        }

    }
}