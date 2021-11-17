package com.sumeshpandit.movie_featuremvvm.api

import com.sumeshpandit.movie_featuremvvm.model.MovieDetailsData
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/3/trending/movie/week?api_key=190468dc1c1669233fd28bec0dacca7d")
    fun getTrendingMovieList(): Call<MovieResponse>

    @GET("/3/movie/now_playing?api_key=190468dc1c1669233fd28bec0dacca7d")
    fun getNowPlayingMovieList(): Call<MovieResponse>

    @GET("/3/movie/{movie_id}?api_key=190468dc1c1669233fd28bec0dacca7d")
    fun getMovieDetails( @Path("movie_id")movieId: Int): Call<MovieDetailsData>
}