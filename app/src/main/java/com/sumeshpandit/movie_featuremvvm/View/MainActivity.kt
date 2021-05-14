package com.sumeshpandit.movie_featuremvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sumeshpandit.movie_featuremvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        viewModel= ViewModelProvider(this)[MovieViewModel::class.java]
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getMostPopularMovie(binding)
    }

    private fun getMostPopularMovie(binding: ActivityMainBinding){
        viewModel.getMovie().observe(this, Observer { mostPopularMovieResponse ->
            binding.recyclerView.adapter=MovieAdapter(mostPopularMovieResponse.movies)
            Toast.makeText(baseContext, "Size: " + mostPopularMovieResponse.movies.size.toString(),
                Toast.LENGTH_SHORT).show()
        } )
    }

}