package com.sumeshpandit.movie_featuremvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel() {
   var movieRepository=MovieRepository()

    fun getMovie():LiveData<MovieResponse>{
        return movieRepository.getPopularMovies()
    }
}