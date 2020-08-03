package com.lucas.barbosa.desafioindra.di

import androidx.room.Room
import com.lucas.barbosa.desafioindra.data.local.AppDatabase
import com.lucas.barbosa.desafioindra.data.local.MIGRATION_1_2
import com.lucas.barbosa.desafioindra.repository.MoviesRepository
import com.lucas.barbosa.desafioindra.repository.MoviesRepositoryImpl
import com.lucas.barbosa.desafioindra.ui.detail.DetailViewModel
import com.lucas.barbosa.desafioindra.ui.list.ListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModules = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "movieList")
            .addMigrations(MIGRATION_1_2).build()
    }

    single { get<AppDatabase>().movieDao() }
    single { get<AppDatabase>().genreDao() }
    factory<MoviesRepository> { MoviesRepositoryImpl(get(), get()) }
}

var viewModels = module {
    viewModel { ListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}