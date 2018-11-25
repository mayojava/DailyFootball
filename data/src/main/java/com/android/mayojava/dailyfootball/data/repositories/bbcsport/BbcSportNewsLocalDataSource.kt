package com.android.mayojava.dailyfootball.data.repositories.bbcsport

import com.android.mayojava.dailyfootball.data.daos.BbcSportsDao
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import io.reactivex.Flowable
import javax.inject.Inject

class BbcSportNewsLocalDataSource @Inject constructor(private val bbcSportsDao: BbcSportsDao) {

    fun observeNews(): Flowable<BbcNewsEntity> = bbcSportsDao.getAllNews()

    fun insertNews(news: List<BbcNewsEntity>) = bbcSportsDao.insert(news)

    fun deleteAllAndInsert(news: List<BbcNewsEntity>) = bbcSportsDao.deleteAllItemsAndInsertAll(news)
}
