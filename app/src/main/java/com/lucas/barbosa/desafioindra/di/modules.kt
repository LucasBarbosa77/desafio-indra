package com.lucas.barbosa.desafioindra.di

import androidx.room.Room
import com.lucas.barbosa.desafioindra.data.local.AppDatabase
import com.lucas.barbosa.desafioindra.repository.MoviesRepository
import com.lucas.barbosa.desafioindra.repository.MoviesRepositoryImpl
import com.lucas.barbosa.desafioindra.ui.detail.DetailViewModel
import com.lucas.barbosa.desafioindra.ui.list.ListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModules = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "movieList").build()
    }

    single { get<AppDatabase>().movieDao() }
    factory<MoviesRepository> { MoviesRepositoryImpl(get()) }
}

var viewModels = module {
    viewModel { ListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}