package com.example.laboratorio_05.ui.movie

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio_05.MovieReviewerApplication
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.data.movies
import com.example.laboratorio_05.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

    fun getMovies() = repository.getMovies()

    fun addMovie(movie: MovieModel) = repository.addMovie(movie)


    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}