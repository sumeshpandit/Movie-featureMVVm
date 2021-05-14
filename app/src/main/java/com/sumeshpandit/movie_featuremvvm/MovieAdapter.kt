package com.sumeshpandit.movie_featuremvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sumeshpandit.movie_featuremvvm.databinding.MovieItemBinding


class MovieAdapter(
    private val movies : List<MovieData>
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: MovieItemBinding = MovieItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(itemBinding)

    }

    class MyViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val ImageBaseUrl = "https://image.tmdb.org/t/p/w500/"

        fun bindMovie(movie: MovieData) {
            binding.movieTitle.text=movie.title
            binding.movieReleaseDate.text=movie.release
            Glide.with(binding.root).load(ImageBaseUrl + movie.poster).into(binding.moviePoster)
            binding.executePendingBindings()
        }
    }
    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }
}