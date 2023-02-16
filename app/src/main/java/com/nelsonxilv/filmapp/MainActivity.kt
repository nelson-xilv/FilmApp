package com.nelsonxilv.filmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nelsonxilv.filmapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FilmsAdapter
    private lateinit var filmViewModel: FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FilmsAdapter()
        filmViewModel = FilmViewModel()

        binding.recyclerView.adapter = adapter

        adapter.films = filmViewModel.films
    }
}