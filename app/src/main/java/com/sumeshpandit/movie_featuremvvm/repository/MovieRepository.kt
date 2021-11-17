package com.sumeshpandit.movie_featuremvvm.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sumeshpandit.movie_featuremvvm.api.ApiService
import com.sumeshpandit.movie_featuremvvm.api.MovieApiClient
import com.sumeshpandit.movie_featuremvvm.model.MovieDetailsData
import com.sumeshpandit.movie_featuremvvm.model.MovieResponse
import com.sumeshpandit.movie_featuremvvm.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    private var apiService: ApiService = MovieApiClient.getInstance().create(ApiService::class.java)

    fun getTrendingMovies(): LiveData<MovieResponse>{
       val movieData: MutableLiveData<MovieResponse> = MutableLiveData()
        apiService.getTrendingMovieList().enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movieData.value=response.body()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                movieData.value=null
                Toast.makeText(MainActivity().baseContext,"Wrong",Toast.LENGTH_SHORT).show()
            }
        })
        return movieData
    }

    fun getNowPlayingMovies(): LiveData<MovieResponse>{
        val movieData: MutableLiveData<MovieResponse> = MutableLiveData()
        apiService.getNowPlayingMovieList().enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movieData.value=response.body()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                movieData.value=null
            }
        })
        return movieData
    }

    fun getMovieDetails(movieId: Int): LiveData<MovieDetailsData>{
        val movieDetails = MutableLiveData<MovieDetailsData>()
        apiService.getMovieDetails(movieId).enqueue(object : Callback<MovieDetailsData>{
            override fun onResponse(
                call: Call<MovieDetailsData>,
                response: Response<MovieDetailsData>
            ) {
                movieDetails.value = response.body()
            }

            override fun onFailure(call: Call<MovieDetailsData>, t: Throwable) {
                movieDetails.value = null
            }
        })
        return  movieDetails
    }
}