package com.example.laboratorio_05.repository

import com.example.laboratorio_05.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>){

    fun getMovies() = movies

    fun addMovie(newMovie: MovieModel){
        movies.add(newMovie)
    }

    /*
    fun deleteMovie(movie: MovieModel){
        movies.remove(movie)
    }
     */

}