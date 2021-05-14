package com.sumeshpandit.movie_featuremvvm

import com.google.gson.annotations.SerializedName
import com.sumeshpandit.movie_featuremvvm.Model.MovieData

class MovieResponse (
    @SerializedName("results")
    var movies : List<MovieData> = mutableListOf()
)