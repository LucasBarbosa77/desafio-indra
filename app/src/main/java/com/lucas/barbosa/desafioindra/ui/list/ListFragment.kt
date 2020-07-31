package com.lucas.barbosa.desafioindra.ui.list

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.lucas.barbosa.desafioindra.R
import com.lucas.barbosa.desafioindra.databinding.FragmentListBinding
import com.lucas.barbosa.desafioindra.utils.RecyclerItemClickListener
import com.lucas.barbosa.desafioindra.utils.callbackRecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModel()
    private val adapter by lazy {
        MovieAdapter(arrayListOf(), requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
        setUp()
        return binding.root
    }

    private fun setUp() {

        binding.recyclerMovies.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                adapter.updateData(it)
                adapter.notifyDataSetChanged()
            }
        })

        binding.recyclerMovies.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                binding.recyclerMovies,
                callbackRecyclerView(
                    onClick = { view, position ->
                        openMovieDetail(adapter.getItemAtPosition(position).id)
                    },
                    onLongClick = { view, position ->

                    }
                )
            )
        )
        viewModel.getPopularMovies()
    }

    private fun openMovieDetail(movieId: Int) {
        val bundle = bundleOf("movieId" to movieId)
        view?.findNavController()?.navigate(R.id.detailFragment, bundle)
    }

}