package com.sumeshpandit.movie_featuremvvm.koin

import com.sumeshpandit.movie_featuremvvm.api.ApiService
import com.sumeshpandit.movie_featuremvvm.api.MovieApiClient
import com.sumeshpandit.movie_featuremvvm.view.MovieAdapter
import com.sumeshpandit.movie_featuremvvm.viewModel.MovieRepository
import com.sumeshpandit.movie_featuremvvm.viewModel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.emptyParametersHolder
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val appModule = module {

    single  { MovieRepository() }
    single { MovieApiClient() }
    factory { params-> MovieAdapter(movies = params.get()) }
    viewModel { MovieViewModel() }
}
