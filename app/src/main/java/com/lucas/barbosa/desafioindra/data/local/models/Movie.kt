package com.lucas.barbosa.desafioindra.data.local.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.common.reflect.TypeToken
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,
    @ColumnInfo(name = "post_path")
    @SerializedName("poster_path")
    val postPath: String,
    @ColumnInfo(name = "runtime")
    @SerializedName("runtime")
    val runtime: Int,
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String
) {
    @Ignore
    @SerializedName("genres")
    var genres: List<Genre> = arrayListOf()

    fun getGenres(): String {
        val genres = StringBuilder()
        for (genre in this.genres) {
            genres.append(genre.name)
            genres.append(", ")
        }
        if(genres.isNotEmpty()){
            genres.deleteCharAt(genres.lastIndex)
            genres.deleteCharAt(genres.lastIndex)
        }
        return genres.toString()
    }

    companion object {
        val myType = object : TypeToken<List<Movie>>() {}.type
    }
}