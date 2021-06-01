package com.sumeshpandit.movie_featuremvvm.data

import com.sumeshpandit.movie_featuremvvm.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/popular?api_key=190468dc1c1669233fd28bec0dacca7d")
     fun getMovieList(): Response<MovieResponse>
}