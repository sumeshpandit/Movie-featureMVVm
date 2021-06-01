package com.sumeshpandit.movie_featuremvvm.domain.usecase.base

import com.sumeshpandit.movie_featuremvvm.domain.model.MovieResponse
import kotlinx.coroutines.*
import retrofit2.Response

abstract class UseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(): Response<MovieResponse>


    fun invoke(scope: CoroutineScope, onResult: UseCaseResponse<Type>?) {

        scope.launch {
                val result = run()
                onResult?.onSuccess(result)
        }
    }

}