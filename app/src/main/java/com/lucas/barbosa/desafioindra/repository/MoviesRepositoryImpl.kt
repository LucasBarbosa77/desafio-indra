package com.lucas.barbosa.desafioindra.repository

import com.google.gson.Gson
import com.lucas.barbosa.desafioindra.data.local.GenreDao
import com.lucas.barbosa.desafioindra.data.local.MovieDao
import com.lucas.barbosa.desafioindra.data.local.models.Movie
import com.lucas.barbosa.desafioindra.data.network.ApiEndPoint
import com.lucas.barbosa.desafioindra.data.network.getRetrofitInstance
import com.lucas.barbosa.desafioindra.data.network.provideApi
import com.lucas.barbosa.desafioindra.utils.callback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject

class MoviesRepositoryImpl(val movieDao: MovieDao, val genreDao: GenreDao) : MoviesRepository {

    private val client: ApiEndPoint = provideApi(getRetrofitInstance())
    val gson = Gson()

    override fun getMovies(
        success: (reponse: List<Movie>) -> Unit,
        error: (throwable: Throwable) -> Unit
    ) {
        client.getMoviesPopular().enqueue(
            callback(
                response = { response ->
                    val results: String = getResults(response?.body())
                    success(gson.fromJson<List<Movie>>(results, Movie.myType))
                },
                failure = { exception ->
                    exception?.let {
                        error(exception)
                    }
                }
            )
        )
    }

    override suspend fun getMovieDetail(
        movieId: Int,
        success: (reponse: Movie) -> Unit,
        error: (throwable: Throwable) -> Unit
    ) {

        val movie = movieDao.selectMovie(movieId)

        if (movie != null) {
            val genres = genreDao.selectGenre(movieId)
            movie.genres = genres
            success(movie)
            return
        }

        client.getMovieDetail(movieId = movieId).enqueue(callback(
            response = { response ->
                val json = response?.body()?.string().toString()
                val movieClass = gson.fromJson(json, Movie::class.java)
                success(movieClass)
                CoroutineScope(Dispatchers.IO).launch {
                    movieDao.insertMovie(movieClass)
                    movieClass.genres.forEach {
                        it.movieId = movieClass.id
                    }
                    genreDao.insertGenre(movieClass.genres)
                }
            },
            failure = { exception ->
                exception?.let {
                    error(exception)
                }
            }
        ))
    }

    private fun getResults(body: ResponseBody?): String {
        val json = JSONObject(body!!.string())
        return json.get("results").toString()
    }

}