package com.android.mayojava.dailyfootball.dataandroid

import android.content.Context
import android.os.Debug
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabase(context: Context): FootballDatabase {
//        val builder = Room.databaseBuilder(context, FootballDatabase::class.java, "dailyfootball.db")
//            .fallbackToDestructiveMigration()
//            .addCallback(object: RoomDatabase.Callback() {
//                override fun onCreate(db: SupportSQLiteDatabase) {
//
//                }
//            })
//
//        if (Debug.isDebuggerConnected()) {
//            builder.allowMainThreadQueries()
//        }
//        return builder.build()
        return FootballDatabase.getInstance(context)
    }

    @Provides
    fun providesBbcDao(db: FootballDatabase) = db.bbcDao()

    @Provides
    fun providesCompetitionsDao(db: FootballDatabase) = db.competitionsDao()

    @Provides
    fun providesTalkSportDao(db: FootballDatabase) = db.talkSportDao()

    @Provides
    fun providesLastRefreshTimeDao(db: FootballDatabase) = db.refreshTimeDao()
}
