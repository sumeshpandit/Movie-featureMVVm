package com.sumeshpandit.movie_featuremvvm.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumeshpandit.movie_featuremvvm.R
import com.sumeshpandit.movie_featuremvvm.databinding.ActivityMainBinding
import com.sumeshpandit.movie_featuremvvm.viewModel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel:MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getMostPopularMovie(binding)
    }

    private fun getMostPopularMovie(binding: ActivityMainBinding){
        myViewModel.getMovie().observe(this, Observer { mostPopularMovieResponse ->
            binding.recyclerView.adapter= MovieAdapter(mostPopularMovieResponse.movies)
            Toast.makeText(baseContext, "No. of Movies: " + mostPopularMovieResponse.movies.size.toString(), Toast.LENGTH_SHORT).show()
        } )
    }
}