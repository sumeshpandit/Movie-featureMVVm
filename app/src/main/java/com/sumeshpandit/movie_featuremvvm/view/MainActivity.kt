package com.sumeshpandit.movie_featuremvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sumeshpandit.movie_featuremvvm.viewmodel.MovieViewModel
import com.sumeshpandit.movie_featuremvvm.R
import com.sumeshpandit.movie_featuremvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MovieAdapter.NavigateToDetailsPage {
    private lateinit var viewModel: MovieViewModel
    private var screen = HOME_PAGE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        viewModel= ViewModelProvider(this)[MovieViewModel::class.java]
        binding.rvTrending.layoutManager = GridLayoutManager(this, 2)
        binding.rvNowPlaying.layoutManager = GridLayoutManager(this, 2)
        getTrendingMovie(binding)
        getNowPlayingMovie(binding)
    }

    private fun getNowPlayingMovie(binding: ActivityMainBinding) {
        viewModel.getNowPlayingMovie().observe(this, { nowPlayingMovies ->
            binding.rvNowPlaying.adapter= MovieAdapter(nowPlayingMovies.movies, this)
        })
    }

    private fun getTrendingMovie(binding: ActivityMainBinding){
        viewModel.getTrendingMovie().observe(this, { trendingMovies ->
            binding.rvTrending.adapter= MovieAdapter(trendingMovies.movies, this)
        })
    }

    override fun itemClicked(id: Int) {
        navigateToDetailsFragment(id)
    }

    private fun navigateToDetailsFragment(movieId: Int){
        val mFragment = MovieDetailsFragment()
        val mBundle = Bundle()
        mBundle.putInt("movie_id",movieId)
        mFragment.arguments = mBundle
        supportFragmentManager.beginTransaction().add(R.id.relative_layout, mFragment).commit()
        screen = DETAILS_PAGE
    }

    override fun onBackPressed() {
        if(screen == DETAILS_PAGE)
            navigateBack()
        else if(screen == HOME_PAGE)
            super.onBackPressed()
    }

    private fun navigateBack() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object{
        const val HOME_PAGE = 1
        const val DETAILS_PAGE = 2
    }
}