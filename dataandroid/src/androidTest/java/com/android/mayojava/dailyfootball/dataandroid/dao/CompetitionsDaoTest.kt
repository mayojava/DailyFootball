package com.android.mayojava.dailyfootball.dataandroid.dao

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.mayojava.dailyfootball.data.daos.CompetitionsDao
import com.android.mayojava.dailyfootball.dataandroid.FootballDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CompetitionsDaoTest {
    private lateinit var competitionsDao: CompetitionsDao
    private lateinit var db: FootballDatabase

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context,
            FootballDatabase::class.java).build()
        competitionsDao = db.competitionsDao()
    }

    @Test
    fun deleteAndInsert_InsertsData() {

    }

    @Test
    fun deleteAndInsert_DeletesExistingData_before_inserting() {

    }

    @After
    fun closeDb() {
        db.close()
    }
}
