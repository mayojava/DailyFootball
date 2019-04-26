package com.android.mayojava.dailyfootball.data.repositories.fourfourtwo

import androidx.paging.DataSource
import com.android.mayojava.dailyfootball.data.daos.FourFourTwoDao
import com.android.mayojava.dailyfootball.data.entities.FourFourTwoEntity
import io.reactivex.Flowable
import javax.inject.Inject

class FourFourTwoLocalDataSource @Inject constructor(private val fourFourTwoDao: FourFourTwoDao) {

    fun observeLatestNews(): Flowable<List<FourFourTwoEntity>> = fourFourTwoDao.getLatestNews()

    fun observeNewsForPagination(): DataSource.Factory<Int, FourFourTwoEntity> = fourFourTwoDao.getNewsPaginated()

    fun deleteAllNews() = fourFourTwoDao.deleteAllNews()

    fun insertNews(news: List<FourFourTwoEntity>) = fourFourTwoDao.insert(news)

    suspend fun newsList(): List<FourFourTwoEntity> = fourFourTwoDao.getLatestNewsList()

    suspend fun getNewsById(id: Long) = fourFourTwoDao.getNewsById(id)

    suspend fun deleteAllAndInsert(news: List<FourFourTwoEntity>) = fourFourTwoDao.deleteAllAndInsert(news)
}
