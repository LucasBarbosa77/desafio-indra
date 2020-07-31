package com.lucas.barbosa.desafioindra.repository

import com.lucas.barbosa.desafioindra.data.local.models.Movie

interface MoviesRepository {

    fun getMovies(
        success: (reponse: List<Movie>) -> Unit,
        error: (throwable: Throwable) -> Unit
    )

    fun getMovieDetail(
        movieId: Int,
        success: (reponse: Movie) -> Unit,
        error: (throwable: Throwable) -> Unit
    )
}