package com.android.mayojava.dailyfootball.data.repositories.bbcsport

import androidx.paging.DataSource
import com.android.mayojava.dailyfootball.data.daos.BbcSportsDao
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import io.reactivex.Flowable
import javax.inject.Inject

class BbcSportNewsLocalDataSource @Inject constructor(private val bbcSportsDao: BbcSportsDao) {

    fun observeNews(): Flowable<List<BbcNewsEntity>> = bbcSportsDao.getAllNews()

    fun observeForPagination(): DataSource.Factory<Int, BbcNewsEntity> = bbcSportsDao.getNewsPaginated()

    fun newsList(): List<BbcNewsEntity> = bbcSportsDao.getNewsList()

    fun insertNews(news: List<BbcNewsEntity>) = bbcSportsDao.insert(news)

    suspend fun deleteAllNews() = bbcSportsDao.deleteAllItems()

    suspend fun deleteAllAndInsert(news: List<BbcNewsEntity>) = bbcSportsDao.deleteAllItemsAndInsertAll(news)
}
