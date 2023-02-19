package com.nelsonxilv.filmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nelsonxilv.filmapp.databinding.ActivityMainBinding
import com.nelsonxilv.filmapp.model.Film
import com.nelsonxilv.filmapp.screens.FilmDetailsFragment
import com.nelsonxilv.filmapp.screens.FilmsListFragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FilmsListFragment())
                .commit()
        }
    }

    override fun showDetails(film: Film) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, FilmDetailsFragment.newInstance(film.id))
            .commit()
    }

    override fun goBack() {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun toast(messageRes: Int) {
        Toast.makeText(this, messageRes, Toast.LENGTH_SHORT).show()
    }
}