package com.sumeshpandit.movie_featuremvvm.domain.usecase

import com.sumeshpandit.movie_featuremvvm.domain.usecase.base.UseCase
import com.sumeshpandit.movie_featuremvvm.domain.model.MovieResponse
import com.sumeshpandit.movie_featuremvvm.domain.repository.MovieRespository
import retrofit2.Response

class GetPostsUseCase constructor(
    private val movieRepository: MovieRespository
) : UseCase<MovieResponse, Any?>() {

    override suspend fun run(): Response<MovieResponse> {
        return movieRepository.getMovieList()
    }

}