package com.lucas.barbosa.desafioindra.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.barbosa.desafioindra.data.local.models.Movie
import com.lucas.barbosa.desafioindra.repository.MoviesRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MoviesRepository) : ViewModel() {

    val movie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            repository.getMovieDetail(movieId, success = {
                movie.postValue(it)
            }, error = {

            })
        }
    }

}