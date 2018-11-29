package com.android.mayojava.dailyfootball.dataandroid

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.mayojava.dailyfootball.data.daos.BbcSportsDao
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity

@Database(entities = [
    BbcNewsEntity::class
], version = 1)
abstract class FootballDatabase: RoomDatabase() {
    abstract fun bbcDao(): BbcSportsDao
}
