package com.sumeshpandit.movie_featuremvvm.model

import com.google.gson.annotations.SerializedName

class MovieResponse (
    @SerializedName("results")
    var movies : List<MovieData> = mutableListOf()
)