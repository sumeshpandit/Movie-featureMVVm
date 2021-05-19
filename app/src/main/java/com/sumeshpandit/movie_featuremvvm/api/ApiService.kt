package com.sumeshpandit.movie_featuremvvm.api

import com.sumeshpandit.movie_featuremvvm.model.MovieResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/popular?api_key=190468dc1c1669233fd28bec0dacca7d")
    fun getMovieList(): Call<MovieResponse>
}