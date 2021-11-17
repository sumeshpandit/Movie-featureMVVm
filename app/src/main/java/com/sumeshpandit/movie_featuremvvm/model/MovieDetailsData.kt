package com.sumeshpandit.movie_featuremvvm.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsData(
    @SerializedName("id")
    val id : String ="",

    @SerializedName("title")
    val title : String="",

    @SerializedName("poster_path")
    val poster : String="",

    @SerializedName("original_language")
    val originalLanguage : String="",

    @SerializedName("overview")
    val overview : String="",

    @SerializedName("release_date")
    val releaseDate : String="",

    @SerializedName("revenue")
    val revenue : Int= 0,

    @SerializedName("runtime")
    val runtime : Int= 0,

    @SerializedName("status")
    val status : String="",

    @SerializedName("tagline")
    val tagline : String= "",

    @SerializedName("vote_average")
    val voteAverage : Float= 0.0f,
)