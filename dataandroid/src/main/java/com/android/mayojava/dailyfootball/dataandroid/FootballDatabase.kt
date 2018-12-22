package com.android.mayojava.dailyfootball.dataandroid

import android.content.Context
import android.os.Debug
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.mayojava.dailyfootball.data.NewsSource
import com.android.mayojava.dailyfootball.data.daos.BbcSportsDao
import com.android.mayojava.dailyfootball.data.daos.CompetitionsDao
import com.android.mayojava.dailyfootball.data.daos.LastRefreshTimeDao
import com.android.mayojava.dailyfootball.data.daos.TalkSportDao
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import com.android.mayojava.dailyfootball.data.entities.LastRefreshTimeEntity
import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [
    BbcNewsEntity::class,
    CompetitionsEntity::class,
    TalkSportEntity::class,
    LastRefreshTimeEntity::class
], version = 1)
abstract class FootballDatabase: RoomDatabase() {
    abstract fun bbcDao(): BbcSportsDao
    abstract fun competitionsDao(): CompetitionsDao
    abstract fun talkSportDao(): TalkSportDao
    abstract fun refreshTimeDao(): LastRefreshTimeDao

    companion object {
        private var INSTANCE: FootballDatabase? = null

        fun getInstance(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context): FootballDatabase {
            val builder = Room.databaseBuilder(context, FootballDatabase::class.java, "dailyfootball.db")
                .fallbackToDestructiveMigration()
                .addCallback(object: RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //create coroutine in GlobalScope to insert default data for refresh
                        GlobalScope.launch(Dispatchers.IO) {
                            getInstance(context).refreshTimeDao().insert(POPULATE_DATA)
                        }
                    }
                })

            if (Debug.isDebuggerConnected()) {
                builder.allowMainThreadQueries()
            }
            return builder.build()
        }

        private val POPULATE_DATA = listOf(
            LastRefreshTimeEntity(NewsSource.bbc, 0L),
            LastRefreshTimeEntity(NewsSource.sportbible, 0L),
            LastRefreshTimeEntity(NewsSource.footballitalia, 0L),
            LastRefreshTimeEntity(NewsSource.fourfourtwo, 0L),
            LastRefreshTimeEntity(NewsSource.talkSport, 0L)
        )
    }
}
