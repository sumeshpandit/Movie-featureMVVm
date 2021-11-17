package com.sumeshpandit.movie_featuremvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.sumeshpandit.movie_featuremvvm.R
import com.sumeshpandit.movie_featuremvvm.databinding.FragmentMovieDetailsBinding
import com.sumeshpandit.movie_featuremvvm.viewmodel.MovieDetailsViewModel

class MovieDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        val movieId = arguments?.getInt("movie_id")
        val binding= activity?.let {
            DataBindingUtil.setContentView<FragmentMovieDetailsBinding>(
                it,
                R.layout.fragment_movie_details
            )
        }
        if (binding != null && movieId != null) {
            setMovieDetails(binding, movieId)
        }
        return view
    }

    private lateinit var viewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }

    private fun setMovieDetails(binding: FragmentMovieDetailsBinding, movieId: Int) {
        viewModel.getMovieDetails(movieId).observe(this, { movie ->
            if(movie != null){
                Glide.with(binding.root).load(ImageBaseUrl + movie.poster).into(binding.ivPoster)
                binding.tvTitle.text = movie.title
                ("Language: " + movie.originalLanguage).also { binding.tvLanguage.text = it }
                binding.tvDescription.text = movie.overview
                ("Release: " + movie.releaseDate).also { binding.tvReleaseData.text = it }
                ("Revenue: $" + movie.revenue.toString()).also { binding.tvRevenue.text = it }
                ("Time: " + movie.runtime.toString() + " min").also { binding.tvRuntime.text = it }
                ("Status: " + movie.status).also { binding.tvStatus.text = it }
                binding.tvTagline.text = movie.tagline
                ("Rating: " + movie.voteAverage.toString()).also { binding.tvVoteAverage.text = it }
            }
        })
    }
}