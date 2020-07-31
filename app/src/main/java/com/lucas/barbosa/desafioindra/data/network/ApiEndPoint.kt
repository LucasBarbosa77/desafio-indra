package com.lucas.barbosa.desafioindra.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiEndPoint {

    @GET("movie/popular")
    fun getMoviesPopular(
        @Query("api_key") apiKey: String = api_key,
        @Query("language") language: String = "pt-br",
        @Query("page") page: Int = 1
    ): Call<ResponseBody>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = api_key,
        @Query("language") language: String = "pt-br"
    ): Call<ResponseBody>
}