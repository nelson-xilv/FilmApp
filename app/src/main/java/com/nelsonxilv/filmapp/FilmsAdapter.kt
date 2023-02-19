package com.nelsonxilv.filmapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nelsonxilv.filmapp.databinding.ItemFilmBinding
import com.nelsonxilv.filmapp.model.Film

interface FilmActionListener {
    fun onFilmDetails(film: Film)
}

class FilmsAdapter(
    private val actionListener: FilmActionListener
) : RecyclerView.Adapter<FilmsAdapter.FilmViewHolder>(), View.OnClickListener {

    var films: List<Film> = emptyList()

    override fun onClick(view: View) {
        val film = view.tag as Film
        actionListener.onFilmDetails(film)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = films[position]
        with(holder.binding) {
            holder.itemView.tag = film

            nameFilmTextView.setText(film.name)
            descriptionFilmTextview.setText(film.description)
            posterFilmImageview.setImageResource(R.drawable.film_poster)
        }
    }

    override fun getItemCount(): Int = films.size

    class FilmViewHolder(
        val binding: ItemFilmBinding
    ) : RecyclerView.ViewHolder(binding.root)
}