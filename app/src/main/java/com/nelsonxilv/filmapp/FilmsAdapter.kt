package com.nelsonxilv.filmapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nelsonxilv.filmapp.databinding.ItemFilmBinding
import com.nelsonxilv.filmapp.model.Film

class FilmsAdapter : RecyclerView.Adapter<FilmsAdapter.FilmViewHolder>() {

    var films: List<Film> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmBinding.inflate(inflater, parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = films[position]
        with(holder.binding) {
            nameFilm.setText(film.name)
            descriptionFilm.setText(film.description)
            photoFilm.setImageResource(R.drawable.film)
        }
    }

    override fun getItemCount(): Int = films.size

    class FilmViewHolder(
        val binding: ItemFilmBinding
    ) : RecyclerView.ViewHolder(binding.root)
}