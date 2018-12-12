package com.android.mayojava.dailyfootball.dataandroid.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.mayojava.dailyfootball.data.daos.BbcSportsDao
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import com.android.mayojava.dailyfootball.dataandroid.FootballDatabase
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BbcSportsDaoTest {
    @JvmField @Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var bbcSportsDao: BbcSportsDao
    private lateinit var db: FootballDatabase

    @Before
    fun createDB() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context,
            FootballDatabase::class.java).build()
        bbcSportsDao = db.bbcDao()
    }
    
    @Test
    fun deleteAll_should_delete_all_items() {
        //Arrange
        bbcSportsDao.insert(getNewsList())

        //Act
        bbcSportsDao.deleteAllItems()

        //Assert
        assertThat(bbcSportsDao.getNewsList()).isEmpty()
    }
    
    @Test
    fun testGetAllNewsFlowable() {
        //Arrange
        bbcSportsDao.insert(getNewsList())

        //Act
        val subscriber = bbcSportsDao.getAllNews().test()

        //Assert
        subscriber.assertNotComplete()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.assertValue(getNewsList())
    }

    @Test
    fun getsNewsList_shouldReturnAllNews() {
        //Arrange
        bbcSportsDao.insert(getNewsList())

        //Act
        val news = bbcSportsDao.getNewsList()

        //Assert
        assertThat(news).isNotEmpty()
        assertThat(news.size).isEqualTo(4)
    }

    @Test
    fun deleteAndInsert_shouldDeleteExistingNews_andInsertNewData() {
        //Arrange
        bbcSportsDao.insert(listOf(
            BbcNewsEntity(6, "author 1", "title 1", "description 1", "",
                "", "2018-12-12", "content 1"),
            BbcNewsEntity(7, "author 2", "title 2", "description 2", "",
                "", "2018-12-12", "content 2")
        ))

        //Act
        bbcSportsDao.deleteAllItemsAndInsertAll(getNewsList())
        val news = bbcSportsDao.getNewsList()

        //Assert
        assertThat(news).isNotEmpty()
        assertThat(news.size).isEqualTo(4)
    }

    @After
    fun closeDB() {
        db.close()
    }

    private fun getNewsList(): List<BbcNewsEntity> {
        return listOf(
            BbcNewsEntity(1, "Bbc", "He is here", "he came again", "", "",
                "2018-12-12", "Awesome content"),
            BbcNewsEntity(2, "Bbc", "Ronaldo is great", "Ronaldo the great footballer", "", "",
                "2018-12-12", "Ronaldo is indeed great"),
            BbcNewsEntity(3, "Bbc", "Champions League Tonight", "Champions League is back tonight", "", "",
                "2018-12-12", "Champions league is back tonight and we are excited"),
            BbcNewsEntity(4, "Bbc", "Real Madrid", "Real Madrid making moves", "", "",
                "2018-12-12", "Real Madrid making moves to sign new players")
        )
    }
}