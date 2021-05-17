package com.sumeshpandit.movie_featuremvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumeshpandit.movie_featuremvvm.viewModel.MovieViewModel
import com.sumeshpandit.movie_featuremvvm.R
import com.sumeshpandit.movie_featuremvvm.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var myViewModel: MovieViewModel = getViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        myViewModel= ViewModelProvider(this)[MovieViewModel::class.java]
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getMostPopularMovie(binding)
    }

    private fun getMostPopularMovie(binding: ActivityMainBinding){
        myViewModel.getMovie().observe(this, Observer { mostPopularMovieResponse ->
            binding.recyclerView.adapter= MovieAdapter(mostPopularMovieResponse.movies)
            Toast.makeText(baseContext, "No. of Movies: " + mostPopularMovieResponse.movies.size.toString(),
                Toast.LENGTH_SHORT).show()
        } )
    }

}