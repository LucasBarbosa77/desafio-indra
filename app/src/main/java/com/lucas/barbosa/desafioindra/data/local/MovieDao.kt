package com.lucas.barbosa.desafioindra.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lucas.barbosa.desafioindra.data.local.models.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Query("select * from movie where id = :id")
    suspend fun selectMovie(id: Int): Movie
}