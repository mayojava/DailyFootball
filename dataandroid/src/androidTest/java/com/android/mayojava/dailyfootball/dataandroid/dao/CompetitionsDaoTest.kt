package com.android.mayojava.dailyfootball.dataandroid.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.mayojava.dailyfootball.data.daos.CompetitionsDao
import com.android.mayojava.dailyfootball.data.entities.AreaEntity
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import com.android.mayojava.dailyfootball.data.entities.CurrentSeasonEntity
import com.android.mayojava.dailyfootball.dataandroid.FootballDatabase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CompetitionsDaoTest {
    @JvmField @Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

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
        runBlocking {
            competitionsDao.deleteAllAndInsert(getCompetitions())
            assertThat(competitionsDao.getCompetitionsList().size).isEqualTo(3)
        }
    }

    @Test
    fun deleteAndInsert_DeletesExistingData_before_inserting() {
        runBlocking {
            //inserts initial data
            competitionsDao.insert(listOf(
                singleCompetition()
            ))

            //Act
            competitionsDao.deleteAllAndInsert(getCompetitions())

            //Assert
            assertThat(competitionsDao.getCompetitionsList().size).isEqualTo(3)
        }
    }

    @Test
    fun delete_deletesAllItems() {
        runBlocking {
            //Arrange
            competitionsDao.insert(getCompetitions())

            //Act
            competitionsDao.deleteAllItems()

            //Assert
            assertThat(competitionsDao.getCompetitionsList()).isEmpty()
        }
    }

    @Test
    fun getCompetitionsList_shouldReturnList() {
        runBlocking {
            //Arrange
            competitionsDao.insert(getCompetitions())

            //Act
            val result = competitionsDao.getCompetitionsList()

            //Assert
            assertThat(result).isNotEmpty()
            assertThat(result.size).isEqualTo(3)
        }
    }

    @Test
    fun testFlowable() {
        runBlocking<Unit> {
            //Arrange
            val testCompetitions = getCompetitions()
            competitionsDao.insert(testCompetitions)

            //Act
            val subscriber = competitionsDao.getCompetitions().test()

            //Assert
            subscriber.assertNotComplete()
            subscriber.assertNotTerminated()
            subscriber.assertValueAt(0, testCompetitions)
            subscriber.assertValueCount(1)

        }
    }

    @After
    fun closeDb() {
        db.close()
    }

    private fun singleCompetition(): CompetitionsEntity =
        CompetitionsEntity(10,
            AreaEntity(30, "Finland"), "Finish", "FL", "url",
            "", CurrentSeasonEntity(10, "2018-04-02", "2019-05-10", 8),
            12, ""
        )

    private fun getCompetitions(): List<CompetitionsEntity> {
        return mutableListOf(
            CompetitionsEntity(1,
                AreaEntity(1, "Spain"), "LaLiga", "LL", "url",
                "", CurrentSeasonEntity(1, "2018-10-10", "2019-10-10", 2),
                10, ""
            ),
            CompetitionsEntity(2,
                AreaEntity(2, "England"), "Premier League", "EPL", "url",
                "", CurrentSeasonEntity(1, "2018-10-10", "2019-10-10", 4),
                1, ""
            ),
            CompetitionsEntity(3,
                AreaEntity(3, "Italy"), "Serie A", "SA", "url",
                "", CurrentSeasonEntity(1, "2018-10-10", "2019-10-10", 9),
                30, ""
            )
        )
    }
}
