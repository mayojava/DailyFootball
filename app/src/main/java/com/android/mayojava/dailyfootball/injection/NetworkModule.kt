package com.android.mayojava.dailyfootball.injection

import com.android.mayojava.dailyfootball.BuildConfig
import com.android.mayojava.dailyfootball.DailyFootballApplication
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import javax.inject.Named

@Module
object NetworkModule {
    @Provides
    @JvmStatic
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @Provides
    @JvmStatic
    @Named("cache-dir")
    fun providesCacheDir(application: DailyFootballApplication): File = application.cacheDir
}
