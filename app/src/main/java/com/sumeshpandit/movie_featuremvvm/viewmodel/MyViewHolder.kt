package com.sumeshpandit.movie_featuremvvm.viewmodel

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sumeshpandit.movie_featuremvvm.databinding.MovieItemBinding
import com.sumeshpandit.movie_featuremvvm.model.MovieData
import com.sumeshpandit.movie_featuremvvm.view.ImageBaseUrl


class MyViewHolder(private val binding: MovieItemBinding, private val onClickInterface: OnClickInterface) : RecyclerView.ViewHolder(binding.root){


    fun bindMovie(movie: MovieData) {
        binding.movieTitle.text=movie.title
        binding.movieReleaseDate.text=movie.release
        binding.moviePoster.setOnClickListener {
            onClickInterface.itemClicked(movie.id.toInt())
        }
        Glide.with(binding.root).load(ImageBaseUrl + movie.poster).into(binding.moviePoster)
        binding.executePendingBindings()
    }

    interface OnClickInterface{
        fun itemClicked(id: Int)
    }
}