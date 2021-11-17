package com.sumeshpandit.movie_featuremvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieApiClient {

        private const val BASE_URL = "https://api.themoviedb.org"
        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit{
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
}