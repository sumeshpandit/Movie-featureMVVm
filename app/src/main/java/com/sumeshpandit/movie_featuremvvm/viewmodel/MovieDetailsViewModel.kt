package com.sumeshpandit.movie_featuremvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sumeshpandit.movie_featuremvvm.model.MovieDetailsData
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse
import com.sumeshpandit.movie_featuremvvm.repository.MovieRepository

class MovieDetailsViewModel: ViewModel() {

    var movieRepository= MovieRepository()

    fun getMovieDetails(movieId: Int): LiveData<MovieDetailsData> {
        return movieRepository.getMovieDetails(movieId)
    }
}