package com.sumeshpandit.movie_featuremvvm.koin

import com.sumeshpandit.movie_featuremvvm.api.ApiService
import com.sumeshpandit.movie_featuremvvm.api.MovieApiClient
import com.sumeshpandit.movie_featuremvvm.viewModel.MovieRepository
import com.sumeshpandit.movie_featuremvvm.viewModel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single  { MovieRepository() }
    single { MovieApiClient() }
    viewModel { MovieViewModel() }
}
