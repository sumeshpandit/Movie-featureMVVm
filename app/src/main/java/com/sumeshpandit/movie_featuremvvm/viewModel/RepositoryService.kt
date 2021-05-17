package com.sumeshpandit.movie_featuremvvm.viewModel

import androidx.lifecycle.LiveData
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse

interface RepositoryService {
    fun getPopularMovies(): LiveData<MovieResponse>
}