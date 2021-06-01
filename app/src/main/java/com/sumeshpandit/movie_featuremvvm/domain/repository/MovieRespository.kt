package com.sumeshpandit.movie_featuremvvm.domain.repository

import com.sumeshpandit.movie_featuremvvm.domain.model.MovieResponse
import retrofit2.Response

interface MovieRespository {
     fun getMovieList(): Response<MovieResponse>
}