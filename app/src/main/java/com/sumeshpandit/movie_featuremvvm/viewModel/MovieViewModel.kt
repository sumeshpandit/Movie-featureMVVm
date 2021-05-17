package com.sumeshpandit.movie_featuremvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse

class MovieViewModel: ViewModel() {

    private var movieRepository= MovieRepository()

    fun getMovie():LiveData<MovieResponse>{
        return movieRepository.getPopularMovies()
    }
}