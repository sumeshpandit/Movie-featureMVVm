package com.sumeshpandit.movie_featuremvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumeshpandit.movie_featuremvvm.R
import com.sumeshpandit.movie_featuremvvm.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        myViewModel.getMovie()

        binding.recyclerView.adapter= myViewModel.responseData.value?.let { MovieAdapter(it.movies) }

    }
}