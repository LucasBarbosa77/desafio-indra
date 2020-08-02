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
    var moviesOrigin: List<Movie>? = arrayListOf()
    fun getPopularMovies() {
        viewModelScope.launch {
            repository.getMovies(success = {
                movies.postValue(it)
                moviesOrigin = it
            }, error = {

            })
        }
    }

    fun textSearch(
        s: CharSequence, start: Int, before: Int,
        count: Int
    ) {
        if (s.length < 2) {
            movies.value = moviesOrigin
            return
        }
        val filter = moviesOrigin?.filter { l -> l.title.contains(s) }
        movies.value = filter
    }
}
