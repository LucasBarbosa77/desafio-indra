package com.lucas.barbosa.desafioindra.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lucas.barbosa.desafioindra.data.local.models.Genre
import com.lucas.barbosa.desafioindra.data.local.models.Movie

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGenre(genre: List<Genre>)

    @Query("select * from genre where movie_id = :movieId")
    suspend fun selectGenre(movieId: Int): List<Genre>
}