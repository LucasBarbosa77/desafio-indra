package com.lucas.barbosa.desafioindra

import android.app.Application
import com.lucas.barbosa.desafioindra.di.appModules
import com.lucas.barbosa.desafioindra.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(arrayListOf(appModules, viewModels))
        }

    }

}