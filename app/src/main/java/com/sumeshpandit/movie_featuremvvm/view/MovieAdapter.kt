package com.sumeshpandit.movie_featuremvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sumeshpandit.movie_featuremvvm.model.MovieData
import com.sumeshpandit.movie_featuremvvm.databinding.MovieItemBinding
import com.sumeshpandit.movie_featuremvvm.viewmodel.MyViewHolder

const val ImageBaseUrl = "https://image.tmdb.org/t/p/w500/"

class MovieAdapter(
    private val movies : List<MovieData>,
    private val navigateToDetailsPage: NavigateToDetailsPage
) : RecyclerView.Adapter<MyViewHolder>(), MyViewHolder.OnClickInterface{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: MovieItemBinding = MovieItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(itemBinding, this)

    }


    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun itemClicked(id: Int) {
        navigateToDetailsPage.itemClicked(id)
    }

    interface NavigateToDetailsPage{
        fun itemClicked(id: Int)
    }

}