package com.sumeshpandit.movie_featuremvvm.data

import com.sumeshpandit.movie_featuremvvm.domain.repository.MovieRespository
import com.sumeshpandit.movie_featuremvvm.domain.model.MovieResponse
import retrofit2.Response

class MovieRepositoryImp(private val apiService: ApiService): MovieRespository {
    override fun getMovieList(): Response<MovieResponse> {
        return apiService.getMovieList()
    }
}