package com.android.mayojava.dailyfootball.injection

import com.android.mayojava.dailyfootball.BuildConfig
import com.android.mayojava.dailyfootball.DailyFootballApplication
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun providesHttpLogginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BASIC
            }
        }
    }

    @Provides
    @Singleton
    @Named("cache-dir")
    fun providesCacheDir(application: DailyFootballApplication): File = application.cacheDir
}
