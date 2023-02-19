package com.nelsonxilv.filmapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nelsonxilv.filmapp.FilmActionListener
import com.nelsonxilv.filmapp.FilmsAdapter
import com.nelsonxilv.filmapp.databinding.FragmentFilmsListBinding
import com.nelsonxilv.filmapp.model.Film

class FilmsListFragment : Fragment() {

    private lateinit var binding: FragmentFilmsListBinding
    private lateinit var adapter: FilmsAdapter

    private val viewModel: FilmsListViewModel by viewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmsListBinding.inflate(inflater, container, false)

        adapter = FilmsAdapter(object : FilmActionListener {
            override fun onFilmDetails(film: Film) {
                navigation().showDetails(film)
            }
        })

        viewModel.films.observe(viewLifecycleOwner) {
            adapter.films = it
        }

        binding.recyclerView.adapter = adapter

        return binding.root
    }

}