package com.example.laboratorio_05.ui.movie.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){


    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit){

        binding.movieName.text = movie.name
        binding.movieScore.text = movie.qualifier

        binding.cardMovie.setOnClickListener{
            clickListener(movie)
        }
    }
}