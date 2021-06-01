package com.sumeshpandit.movie_featuremvvm.di

import com.sumeshpandit.movie_featuremvvm.data.MovieRepositoryImp
import com.sumeshpandit.movie_featuremvvm.presentation.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { MovieRepositoryImp(get()) }
    viewModel { MovieViewModel(get()) }
    single { createGetPostsUseCase(get()) }
    single { createPostRepository(get()) }
}
