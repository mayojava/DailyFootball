package com.android.mayojava.dailyfootball.injection

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.work.WorkManager
import com.android.mayojava.dailyfootball.BuildConfig
import com.android.mayojava.dailyfootball.DailyFootballApplication
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.base.util.Logger
import com.android.mayojava.dailyfootball.baseandroid.TimberLogger
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesContext(application: DailyFootballApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideCoroutineDispatchers(): AppCoroutineDispatchers = AppCoroutineDispatchers(
        io = Dispatchers.IO,
        computation = Dispatchers.Default,
        main = Dispatchers.Main
    )

    @Provides
    @Singleton
    fun providesSharedPreferencesManager(application: DailyFootballApplication): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun providesWorkManager(): WorkManager = WorkManager.getInstance()

    @Provides
    @Named("news-api-key")
    fun providesNewsApiKey(): String = BuildConfig.NEWS_API_KEY

    @Provides
    @Named("football-data-token")
    fun providesFootballDataToken(): String = BuildConfig.FOOTBALL_DATA_TOKEN

    @Provides
    fun providesLogger(timber: TimberLogger): Logger = timber
}
