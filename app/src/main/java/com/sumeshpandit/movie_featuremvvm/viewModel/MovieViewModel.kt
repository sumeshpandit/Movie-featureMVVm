package com.sumeshpandit.movie_featuremvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieViewModel: ViewModel(), KoinComponent {
    private val movieRepository: MovieRepository by inject()
    private lateinit var responseData:LiveData<MovieResponse>

    fun getMovie():LiveData<MovieResponse>{
            viewModelScope.launch {
                responseData=movieRepository.getPopularMovies()
            }
        return responseData
    }
}