package com.sumeshpandit.movie_featuremvvm.koin

import com.sumeshpandit.movie_featuremvvm.viewModel.MovieRepository
import com.sumeshpandit.movie_featuremvvm.viewModel.MovieViewModel
import com.sumeshpandit.movie_featuremvvm.viewModel.RepositoryService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<RepositoryService> { MovieRepository() }

    viewModel { MovieViewModel(get()) }
}