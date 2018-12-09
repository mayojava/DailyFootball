package com.android.mayojava.dailyfootball.data.services

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServicesModule {
    private val cacheSize: Long = 10 * 1024 * 1024

    @Provides
    @Singleton
    fun providesNewsApi(logger: HttpLoggingInterceptor,
                        @Named("cache-dir") cacheDir: File,
                        @Named("news-api-key") apiKey: String): NewsApi {

        return object: NewsApi(apiKey) {
            override fun setOkHttpClientDefaults(builder: OkHttpClient.Builder) {
                super.setOkHttpClientDefaults(builder)
                builder.apply {
                    addInterceptor(logger)
                    cache(Cache(File(cacheDir, "news-api-cache"), cacheSize))
                }
            }
        }
    }

    @Provides
    @Singleton
    fun providesFootballDataApi(logger: HttpLoggingInterceptor,
                                @Named("cache-dir") cacheDir: File,
                                @Named("football-data-token") token: String): FootballDataApi {

        return object: FootballDataApi(token) {
            override fun setOkHttpClientDefaults(builder: OkHttpClient.Builder) {
                super.setOkHttpClientDefaults(builder)
                builder.apply {
                    addInterceptor(logger)
                    cache(Cache(File(cacheDir, "football-data-cache"), cacheSize))
                }
            }
        }
    }
}
