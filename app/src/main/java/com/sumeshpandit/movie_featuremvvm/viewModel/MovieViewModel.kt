package com.sumeshpandit.movie_featuremvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieViewModel: ViewModel(), KoinComponent {

    private val movieRepository: MovieRepository by inject()
    fun getMovie():LiveData<MovieResponse>{
        return movieRepository.getPopularMovies()
    }
}