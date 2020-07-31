package com.lucas.barbosa.desafioindra.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.barbosa.desafioindra.R
import com.lucas.barbosa.desafioindra.data.local.models.Movie
import com.lucas.barbosa.desafioindra.repository.MoviesRepository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(private val repository: MoviesRepository) : ViewModel() {

    val movies: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getPopularMovies() {
        viewModelScope.launch {
            repository.getMovies(success = {
                movies.postValue(it)
            }, error = {

            })
        }
    }
}
