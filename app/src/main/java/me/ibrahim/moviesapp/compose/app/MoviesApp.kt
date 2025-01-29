package me.ibrahim.moviesapp.compose.app

import android.app.Application
import me.ibrahim.moviesapp.compose.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MoviesApp)
            androidLogger(level = Level.ERROR)
            modules(koinModule)
        }
    }
}