package com.android.mayojava.dailyfootball.interactor

import androidx.paging.DataSource
import com.android.mayojava.dailyfootball.data.NewsSource
import com.android.mayojava.dailyfootball.data.daos.LastRefreshTimeDao
import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity
import com.android.mayojava.dailyfootball.data.repositories.talksport.TalkSportRepository
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.reactive.openSubscription
import javax.inject.Inject

class TalkSportInteractor @Inject constructor(private val talkSportRepository: TalkSportRepository,
                                              private val lastRefreshTimeDao: LastRefreshTimeDao):
    PagingInteractor<TalkSportEntity>, RunnableInteractor<List<TalkSportEntity>>(), NewsRefresher {

    override fun dataSourceFactory(): DataSource.Factory<Int, TalkSportEntity> = talkSportRepository.observeNewsForPaging()

    override suspend fun execute() {
        refreshIfOutdated(NewsSource.talkSport, lastRefreshTimeDao) {
            talkSportRepository.updateTalkSportNews()
        }
    }

    override fun observe(): ReceiveChannel<List<TalkSportEntity>> = talkSportRepository.observeNews().openSubscription()

    suspend fun getNewsById(id: Long): TalkSportEntity = talkSportRepository.getNewsById(id)
}
