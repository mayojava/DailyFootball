package com.android.mayojava.dailyfootball.interactor

import androidx.paging.DataSource
import com.android.mayojava.dailyfootball.data.NewsSource
import com.android.mayojava.dailyfootball.data.daos.LastRefreshTimeDao
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import com.android.mayojava.dailyfootball.data.repositories.bbcsport.BbcSportNewsRepository
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.reactive.openSubscription
import javax.inject.Inject

class BbcNewsInteractor @Inject constructor(private val bbcSportNewsRepository: BbcSportNewsRepository,
                                            private val lastRefreshTimeDao: LastRefreshTimeDao)
    : PagingInteractor<BbcNewsEntity>, RunnableInteractor<List<BbcNewsEntity>>(), NewsRefresher {

    override fun dataSourceFactory(): DataSource.Factory<Int, BbcNewsEntity>
            = bbcSportNewsRepository.observeNewsForPaging()

    override suspend fun execute() {
        refreshIfOutdated(NewsSource.bbc, lastRefreshTimeDao) {
            bbcSportNewsRepository.fetchNewsUpdate()
        }
    }

    override fun observe(): ReceiveChannel<List<BbcNewsEntity>> {
        return bbcSportNewsRepository.observeNews().openSubscription()
    }

    suspend fun getNewsById(newsId: Long): BbcNewsEntity = bbcSportNewsRepository.getNewsById(newsId)
}
