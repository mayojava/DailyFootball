package com.android.mayojava.dailyfootball.dataandroid

import android.content.Context
import android.os.Debug
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabase(context: Context): FootballDatabase {
        val builder = Room.databaseBuilder(context, FootballDatabase::class.java, "dailyfootball.db")
            .fallbackToDestructiveMigration()

        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }

    @Provides
    fun providesBbcDao(db: FootballDatabase) = db.bbcDao()

    @Provides
    fun providesCompetitionsDao(db: FootballDatabase) = db.competitionsDao()

    @Provides
    fun providesTalkSportDao(db: FootballDatabase) = db.talkSportDao()
}
