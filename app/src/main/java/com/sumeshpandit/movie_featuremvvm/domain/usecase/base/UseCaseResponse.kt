package com.sumeshpandit.movie_featuremvvm.domain.usecase.base

import com.sumeshpandit.movie_featuremvvm.domain.model.MovieResponse
import retrofit2.Response

interface UseCaseResponse<Type> {

    fun onSuccess(result: Response<MovieResponse>)

}

