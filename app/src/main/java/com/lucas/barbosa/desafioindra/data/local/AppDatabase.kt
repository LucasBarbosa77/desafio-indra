package com.lucas.barbosa.desafioindra.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucas.barbosa.desafioindra.data.local.models.Genre
import com.lucas.barbosa.desafioindra.data.local.models.Movie

@Database(
    exportSchema = false,
    entities = [Movie::class, Genre::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun genreDao(): GenreDao

}