package com.sumeshpandit.movie_featuremvvm.di

import com.sumeshpandit.movie_featuremvvm.data.ApiService
import com.sumeshpandit.movie_featuremvvm.data.MovieRepositoryImp
import com.sumeshpandit.movie_featuremvvm.domain.repository.MovieRespository
import com.sumeshpandit.movie_featuremvvm.domain.usecase.GetPostsUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.themoviedb.org"

private const val TIME_OUT = 30L

val NetworkModule = module {

    single { createService(get()) }

    single { createRetrofit() }

    single { GsonConverterFactory.create() }

}


fun createRetrofit(): Retrofit{
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

fun createPostRepository(apiService: ApiService): MovieRespository {
    return MovieRepositoryImp(apiService)
}

fun createGetPostsUseCase(postsRepository: MovieRespository): GetPostsUseCase {
    return GetPostsUseCase(postsRepository)
}
