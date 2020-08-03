package com.lucas.barbosa.desafioindra.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("Create table genre(id integer PRIMARY KEY AUTOINCREMENT,movie_id integer,genrer text)")
    }
}