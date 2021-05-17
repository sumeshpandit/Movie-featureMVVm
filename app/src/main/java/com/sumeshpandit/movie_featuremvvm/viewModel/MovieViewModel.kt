package com.sumeshpandit.movie_featuremvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse

class MovieViewModel(val movieRepository: MovieRepository): ViewModel() {

    fun getMovie(): LiveData<MovieResponse> = movieRepository.getPopularMovies()

}