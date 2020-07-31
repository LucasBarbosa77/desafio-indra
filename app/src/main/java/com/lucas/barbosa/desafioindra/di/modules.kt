package com.lucas.barbosa.desafioindra.di

import com.lucas.barbosa.desafioindra.repository.MoviesRepository
import com.lucas.barbosa.desafioindra.repository.MoviesRepositoryImpl
import com.lucas.barbosa.desafioindra.ui.detail.DetailViewModel
import com.lucas.barbosa.desafioindra.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModules = module {
    factory<MoviesRepository> { MoviesRepositoryImpl() }
}

var viewModels = module {
    viewModel { ListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}