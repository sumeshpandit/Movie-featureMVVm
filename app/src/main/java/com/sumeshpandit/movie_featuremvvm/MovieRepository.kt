package com.sumeshpandit.movie_featuremvvm

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    var apiService:ApiService = MovieApiClient.getInstance().create(ApiService::class.java)

    fun getPopularMovies(): LiveData<MovieResponse>{
       val movieData: MutableLiveData<MovieResponse> = MutableLiveData()
        apiService.getMovieList().enqueue(object: Callback<MovieResponse>{
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
}