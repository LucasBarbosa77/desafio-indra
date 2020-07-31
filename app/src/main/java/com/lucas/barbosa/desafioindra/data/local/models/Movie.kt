package com.lucas.barbosa.desafioindra.data.local.models

import android.graphics.Bitmap
import com.google.common.reflect.TypeToken
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val postPath: String,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("genres")
    val genres: List<Genre>
) {

    fun getGenres(): String {
        val genres = StringBuilder()
        for (genre in this.genres) {
            genres.append(genre.name)
            genres.append(", ")
        }
        genres.deleteCharAt(genres.lastIndex)
        genres.deleteCharAt(genres.lastIndex)
        return genres.toString()
    }

    companion object {
        val myType = object : TypeToken<List<Movie>>() {}.type
    }
}