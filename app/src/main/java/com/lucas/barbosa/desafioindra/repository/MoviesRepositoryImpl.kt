package com.lucas.barbosa.desafioindra.repository

import com.google.gson.Gson
import com.lucas.barbosa.desafioindra.data.local.models.Movie
import com.lucas.barbosa.desafioindra.data.network.ApiEndPoint
import com.lucas.barbosa.desafioindra.data.network.getRetrofitInstance
import com.lucas.barbosa.desafioindra.data.network.provideApi
import com.lucas.barbosa.desafioindra.utils.callback
import okhttp3.ResponseBody
import org.json.JSONObject

class MoviesRepositoryImpl() : MoviesRepository {

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

    override fun getMovieDetail(
        movieId: Int,
        success: (reponse: Movie) -> Unit,
        error: (throwable: Throwable) -> Unit
    ) {
        client.getMovieDetail(movieId = movieId).enqueue(callback(
            response = { response ->
                val json = response?.body()?.string().toString()
                success(gson.fromJson(json, Movie::class.java))
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