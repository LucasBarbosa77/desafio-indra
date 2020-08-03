package com.lucas.barbosa.desafioindra.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genre")
data class Genre(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "movie_id")
    var movieId: Int,
    @ColumnInfo(name = "genre")
    @SerializedName("name")
    val name: String
)