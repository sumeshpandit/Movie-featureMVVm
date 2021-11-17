package com.sumeshpandit.movie_featuremvvm.viewmodel

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sumeshpandit.movie_featuremvvm.repository.MovieRepository
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse

class MovieViewModel: ViewModel() {
   var movieRepository= MovieRepository()

    fun getTrendingMovie():LiveData<MovieResponse>{
        return movieRepository.getTrendingMovies()
    }

    fun getNowPlayingMovie(): LiveData<MovieResponse>{
        return movieRepository.getNowPlayingMovies()
    }

}