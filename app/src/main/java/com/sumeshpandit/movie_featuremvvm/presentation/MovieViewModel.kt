package com.sumeshpandit.movie_featuremvvm.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumeshpandit.movie_featuremvvm.domain.model.MovieResponse
import com.sumeshpandit.movie_featuremvvm.domain.usecase.GetPostsUseCase
import com.sumeshpandit.movie_featuremvvm.domain.usecase.base.UseCaseResponse
import org.koin.core.component.KoinComponent
import retrofit2.Response

class MovieViewModel(private val getMovieUseCase: GetPostsUseCase): ViewModel(), KoinComponent {
    var responseData= MutableLiveData<MovieResponse>()

    fun getMovie() {
        getMovieUseCase.invoke(viewModelScope, object : UseCaseResponse<MovieResponse> {
            override fun onSuccess(result: Response<MovieResponse>) {
                        responseData.value?.movies  = result.body()?.movies!!
                }
        })
    }

}