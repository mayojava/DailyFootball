package com.android.mayojava.dailyfootball.injection

import com.android.mayojava.dailyfootball.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule {
    @Provides
    @Named("news-api-key")
    fun providesNewsApiKey(): String = BuildConfig.NEWS_API_KEY

    @Provides
    @Named("football-data-token")
    fun providesFootballDataToken(): String = BuildConfig.FOOTBALL_DATA_TOKEN
}
