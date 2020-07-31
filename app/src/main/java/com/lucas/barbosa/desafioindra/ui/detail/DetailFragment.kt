package com.lucas.barbosa.desafioindra.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.lucas.barbosa.desafioindra.R
import com.lucas.barbosa.desafioindra.databinding.FragmentDetailBinding
import com.lucas.barbosa.desafioindra.ui.list.ListViewModel
import com.lucas.barbosa.desafioindra.utils.getProgressBarIndeterminate
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        setUp()
        return binding.root
    }

    private fun setUp() {
        val movieId = arguments?.getInt("movieId")
        viewModel.getMovieDetail(movieId!!)


        viewModel.movie.observe(viewLifecycleOwner, Observer {
            binding.movieTitle.text = it.title
            binding.movieOverview.text = it.overview
            Picasso.get()
                .load("http://image.tmdb.org/t/p/w185/" + it.postPath)
                .placeholder(getProgressBarIndeterminate(requireContext())!!)
                .into(binding.moviePoster)
            binding.movieRuntime.text =
                StringBuilder().append("Tempo: ").append(it.runtime).append(" minutos")
            binding.movieGenres.text = StringBuilder().append("Genero: ").append(it.getGenres())
        })
    }
}