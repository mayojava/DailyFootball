package com.android.mayojava.dailyfootball.data.repositories.talksport

import androidx.paging.DataSource
import com.android.mayojava.dailyfootball.data.daos.TalkSportDao
import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity
import io.reactivex.Flowable
import javax.inject.Inject

class TalkSportLocalDataSource @Inject constructor(private val talkSportDao: TalkSportDao) {

    fun observeLatestNews(): Flowable<List<TalkSportEntity>> = talkSportDao.getLatestNews()

    fun observeNewsForPagination(): DataSource.Factory<Int, TalkSportEntity> = talkSportDao.getNewsPaginated()

    fun deleteAllNews() = talkSportDao.deleteAllNews()

    fun insertNews(news: List<TalkSportEntity>) = talkSportDao.insert(news)

    suspend fun newsList(): List<TalkSportEntity> = talkSportDao.getLatestNewsList()

    suspend fun getNewsById(id: Long) = talkSportDao.getNewsById(id)

    suspend fun deleteAllAndInsert(news: List<TalkSportEntity>) = talkSportDao.deleteAllItemsAndInsertAll(news)
}
